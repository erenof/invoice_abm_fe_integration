package com.coderhouse.proyecto_final.service;

import com.coderhouse.proyecto_final.model.InvoiceDetail;
import com.coderhouse.proyecto_final.model.InvoiceDetailDTO;
import com.coderhouse.proyecto_final.repository.InvoiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceDetailService {
    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    //Save invoice detail
    public void saveInvoiceDetail(InvoiceDetail invoiceDetail) throws Exception{
        invoiceDetailRepository.save(invoiceDetail);
    }

    //Get invoice details by invoice id
    public List<InvoiceDetailDTO> getInvoiceDetailsByInvoiceId(int invoice_id) throws Exception{
        return invoiceDetailRepository.getInvoiceDetailsByInvoiceId(invoice_id);
    }
}
