package com.coderhouse.proyecto_final.repository;

import com.coderhouse.proyecto_final.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
