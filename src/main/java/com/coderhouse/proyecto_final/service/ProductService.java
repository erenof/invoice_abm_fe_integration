package com.coderhouse.proyecto_final.service;

import com.coderhouse.proyecto_final.model.InvoiceDetailRequest;
import com.coderhouse.proyecto_final.model.Product;
import com.coderhouse.proyecto_final.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //Create a product
    public Product postProduct(Product product) throws Exception{
        return productRepository.save(product);
    }

    //Read product by id
    public Product getProduct(int product_id) throws Exception{
        Optional<Product> product = productRepository.findById(product_id);
        if(product.isEmpty()){
            throw new Exception("Product with id: " + product_id + " ,not found.");
        }else {
            return product.get();
        }
    }

    //List products by id in roder to create the invoice
    public List<Product> getProductsById(List<InvoiceDetailRequest> productListId) throws Exception{
        List<Product> productList = new ArrayList<>();
        for(InvoiceDetailRequest requestProduct:
            productListId) {
            Optional<Product> productFound = productRepository.findById(requestProduct.getProduct_id());
            if(productFound.isEmpty()){
                throw new Exception("Product with id: " + requestProduct.getProduct_id() + ", not found.");
            }else{
                productList.add(productFound.get());
            }
        } return productList;
    }

    //Get all products
    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    //Update a product
    public Product updateProduct(Product product) throws Exception{
        return productRepository.save(product);
    }

    //Delete a product
    public Product deleteProduct(int product_id) throws Exception{
        Optional<Product> product = productRepository.findById(product_id);
        if(product.isEmpty()){
            throw new Exception("Product with id: " + product_id + " not found.");
        }else{
            productRepository.deleteById(product_id);
        }
        return null;
    }
}
