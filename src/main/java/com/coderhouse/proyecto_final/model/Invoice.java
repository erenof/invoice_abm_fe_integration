package com.coderhouse.proyecto_final.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoice_id;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceDetail> invoiceDetails;

    private String created_at;

    private double total;

    // Getters & Setters
    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<InvoiceDetail> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    // toString Method
    @Override
    public String toString() {
        return "Invoice{" +
                "invoice_id=" + invoice_id +
                ", client=" + client +
                ", invoiceDetails=" + invoiceDetails +
                ", created_at='" + created_at + '\'' +
                ", total=" + total +
                '}';
    }
}
