package com.coderhouse.proyecto_final.model;

public class InvoiceDetailDTO {
    private String description;
    private String internal_code;
    private double price;
    private int quantity;

    //Constructor
    public InvoiceDetailDTO(String description, String internal_code, double price, int quantity) {
        this.description = description;
        this.internal_code = internal_code;
        this.price = price;
        this.quantity = quantity;
    }

    public InvoiceDetailDTO() {
    }

    // Getters & Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return internal_code;
    }

    public void setCode(String code) {
        this.internal_code = code;
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
}
