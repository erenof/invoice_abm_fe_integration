package com.coderhouse.proyecto_final.service;

import com.coderhouse.proyecto_final.model.*;
import com.coderhouse.proyecto_final.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @Autowired
    private InvoiceDetailService invoiceDetailService;

    //Save an invoice, we need to get client and related products
    public InvoiceDTO postInvoice(InvoiceRequest invoiceRequest ) throws Exception{
        //get client id using clientService
        Client clientExist = clientService.getClient(invoiceRequest.getClient_id());
        //get the products
        List<Product> productList = productService.getProductsById(invoiceRequest.getProduct_list());
        System.out.println("Lista de productos" + productList);
        //Check stock, if stock is available calculate total
        int p = 0;
        double total = 0;
        int stockUpdated = 0;
        for (Product product:
            productList){
            int productQuantity = invoiceRequest.getProduct_list().get(p).getQuantity();
            int availableStock = product.getStock();
            if(availableStock < productQuantity || availableStock < 0){
                throw new Exception("Product id: " + productService.getProduct(p + 1).getProduct_id() +
                        " " + productService.getProduct(p + 1).getTitle()  + ", NO stock available.");
            }else {
                total += product.getProduct_price() * invoiceRequest.getProduct_list().get(p).getQuantity();
                // Update the stock of the product
                stockUpdated = availableStock - productQuantity;
                product.setStock(stockUpdated);
            }
            p++;
        }

        //Create Invoice with above info
        Invoice invoiceCreated = new Invoice();

        //Set invoice date
        invoiceCreated.setCreated_at(new Date().toString());

        //Set client
        invoiceCreated.setClient(clientExist);

        //Set total
        invoiceCreated.setTotal(total);

        //Save invoice
        invoiceCreated = invoiceRepository.save(invoiceCreated);

        //Set invoice details
        int i = 0;
        for(Product productDetail:
            productList){
            InvoiceDetail newInvoice = new InvoiceDetail();
            //Set final price
            newInvoice.setPrice(productDetail.getProduct_price());
            //Set foreign keys
            newInvoice.setInvoice(invoiceCreated);
            newInvoice.setProduct(productDetail);
            //Set the amount
            newInvoice.setQuantity(invoiceRequest.getProduct_list().get(i).getQuantity());
            invoiceDetailService.saveInvoiceDetail(newInvoice);
            i++;
        }
        //Return DTO
        return new InvoiceDTO(
            invoiceCreated.getInvoice_id(),
            invoiceCreated.getCreated_at(),
            invoiceCreated.getTotal()
        );
    }

    //Get invoices by client_id
    public List<InvoiceDTO> getInvoicesByClientId (int client_id) throws Exception {
        return invoiceRepository.getInvoicesByClientById(client_id);
    }

    //Get invoice by invoice_id
    public InvoiceWithDetailsDTO getInvoiceById (int invoice_id) throws Exception {
        Optional<Invoice> invoiceFound = invoiceRepository.findById(invoice_id);
        if (invoiceFound.isEmpty()) {
            throw new Exception("Invoice not found");
        }

        List<InvoiceDetailDTO> invoice_details = invoiceDetailService.getInvoiceDetailsByInvoiceId(invoice_id);

        return new InvoiceWithDetailsDTO(
                invoiceFound.get().getInvoice_id(),
                invoiceFound.get().getCreated_at(),
                invoiceFound.get().getTotal(),
                invoice_details
        );
    }
}