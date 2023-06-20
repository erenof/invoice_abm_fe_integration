package com.coderhouse.proyecto_final.repository;

import com.coderhouse.proyecto_final.model.InvoiceDetail;
import com.coderhouse.proyecto_final.model.InvoiceDetailDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {

    @Query("SELECT new com.coderhouse.proyecto_final.model.InvoiceDetailDTO(" +
            "p.description, " +
            "p.internal_code, " +
            "d.price, " +
            "d.quantity" +
            ") FROM Invoice i JOIN i.invoiceDetails d JOIN d.product p WHERE i.invoice_id = :id")
    List<InvoiceDetailDTO> getInvoiceDetailsByInvoiceId(@Param("id") int invoice_id);
}
