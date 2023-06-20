package com.coderhouse.proyecto_final.model;

import jakarta.persistence.*;

@Entity
@Table(name = "invoice_detail")
public class InvoiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoice_detail_id;

    @ManyToOne
    @JoinColumn(name = "id_invoice")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    private double price;

    private int quantity;

    // Getters & Setters
    public int getInvoice_detail_id() {
        return invoice_detail_id;
    }

    public void setInvoice_detail_id(int invoice_detail_id) {
        this.invoice_detail_id = invoice_detail_id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // toString Method
    @Override
    public String toString() {
        return "InvoiceDetail{" +
                "invoice_detail_id=" + invoice_detail_id +
                ", invoice=" + invoice +
                ", product=" + product +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
