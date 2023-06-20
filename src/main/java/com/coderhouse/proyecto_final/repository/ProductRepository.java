package com.coderhouse.proyecto_final.repository;

import com.coderhouse.proyecto_final.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
