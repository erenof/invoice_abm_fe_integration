package com.coderhouse.proyecto_final.controller;

import com.coderhouse.proyecto_final.middleware.ResponseHandler;
import com.coderhouse.proyecto_final.model.InvoiceDTO;
import com.coderhouse.proyecto_final.model.InvoiceRequest;
import com.coderhouse.proyecto_final.model.InvoiceWithDetailsDTO;
import com.coderhouse.proyecto_final.service.ClientService;
import com.coderhouse.proyecto_final.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ClientService clientService;

    //CRUD Invoice
    //Create Invoice
    @PostMapping
    public ResponseEntity<Object> postInvoice(@RequestBody InvoiceRequest invoiceRequest){
        try{
            InvoiceDTO invoiceData = invoiceService.postInvoice(invoiceRequest);
            return ResponseHandler.generateResponse(
                    "Invoice created successfully.",
                    HttpStatus.OK,
                    invoiceData
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    //Read Invoice by id
    @GetMapping(path = "{invoice_id}")
    public ResponseEntity<Object> getInvoiceById(@PathVariable int invoice_id){
        try{
            InvoiceWithDetailsDTO invoiceData = invoiceService.getInvoiceById(invoice_id);
            return ResponseHandler.generateResponse(
                    "Invoice retrieved successfully.",
                    HttpStatus.OK,
                    invoiceData
            );
        }catch (Exception e){
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    // Read all invoices by client_id
    @GetMapping(path = "/getInvoicesByClientId/{client_id}")
    public ResponseEntity<Object> getInvoicesByClientId(@PathVariable int client_id){
        try{
            List<InvoiceDTO> invoicesData = invoiceService.getInvoicesByClientId(client_id);
            return ResponseHandler.generateResponse(
                    "Invoices for client: " + clientService.getClient(client_id).getDni()  +" retrieved.",
                    HttpStatus.OK,
                    invoicesData
            );
        }catch (Exception e){
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }
}
