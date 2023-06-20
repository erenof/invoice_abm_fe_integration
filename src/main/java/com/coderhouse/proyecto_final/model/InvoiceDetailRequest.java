package com.coderhouse.proyecto_final.model;

public class InvoiceDetailRequest {
    private int product_id;
    private int quantity;

    // Constructor
    public InvoiceDetailRequest(int product_id, int quantity) {
        this.product_id = product_id;
        this.quantity = quantity;
    }

    // Guetters & Setters
    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
