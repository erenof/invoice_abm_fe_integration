package com.coderhouse.proyecto_final.controller;

import com.coderhouse.proyecto_final.middleware.ResponseHandler;
import com.coderhouse.proyecto_final.model.Product;
import com.coderhouse.proyecto_final.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //CRUD Product
    //Create Product
    @PostMapping
    public ResponseEntity<Object> postProduct(@RequestBody Product product){
        try{
            Product productSaved = productService.postProduct(product);
            return ResponseHandler.generateResponse(
                    "Product saved successfully.",
                    HttpStatus.OK,
                    productSaved
            );
        }catch (Exception e){
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    //Read Product
    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getProduct (@PathVariable() int id){
        try{
            Product productFound = productService.getProduct(id);
            return ResponseHandler.generateResponse(
                    "Product retrieved successfully.",
                    HttpStatus.OK,
                    productFound
            );
        }catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    //Get all products
    @GetMapping(path = "/allproducts")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    //Update Product
    @PutMapping(path = "/update")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product){
        try{
            Product productUpdated = productService.updateProduct(product);
            return ResponseHandler.generateResponse(
                    "Product updated successfully.",
                    HttpStatus.OK,
                    productUpdated
            );
        }catch (Exception e){
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    //Delete Product
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable() int product_id){
        try{
            Product productDeleted = productService.deleteProduct(product_id);
            return ResponseHandler.generateResponse(
                    "Product delted successfully.",
                    HttpStatus.OK,
                    productDeleted
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