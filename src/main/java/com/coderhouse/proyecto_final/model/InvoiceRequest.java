package com.coderhouse.proyecto_final.model;

import java.util.List;

public class InvoiceRequest {

    private int client_id;
    private List<InvoiceDetailRequest> product_list;

    // Constructor
    public InvoiceRequest(int client_id, List<InvoiceDetailRequest> product_list) {
        this.client_id = client_id;
        this.product_list = product_list;
    }

    // Getters & Setters
    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public List<InvoiceDetailRequest> getProduct_list() {
        return product_list;
    }

    public void setProduct_list(List<InvoiceDetailRequest> product_list) {
        this.product_list = product_list;
    }

    // toString method
    @Override
    public String toString() {
        return "InvoiceRequest{" +
                "client_id=" + client_id +
                ", product_list=" + product_list +
                '}';
    }
}
