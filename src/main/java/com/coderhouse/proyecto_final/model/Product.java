package com.coderhouse.proyecto_final.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;

    @NotNull(message = "Text only field.")
    @Column(nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Text only field.")
    private String title;

    @NotNull(message = "Text only field.")
    @Column(nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Text only field.")
    private String description;

    @NotNull(message = "Numbers only.")
    @Column(nullable = false)
    private int stock;

    @NotNull(message = "Numbers only.")
    @Column(nullable = false)
    private double product_price;

    @NotNull(message = "Numbers only.")
    @Column(nullable = false)
    private String internal_code;

    // Getters & Setters
    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public String getInternal_code() {
        return internal_code;
    }

    public void setInternal_code(String internal_code) {
        this.internal_code = internal_code;
    }

    // toString Method
    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", product_price=" + product_price +
                ", internal_code=" + internal_code +
                '}';
    }
}
