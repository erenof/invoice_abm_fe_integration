package com.coderhouse.proyecto_final.controller;

import com.coderhouse.proyecto_final.middleware.ResponseHandler;
import com.coderhouse.proyecto_final.model.Client;
import com.coderhouse.proyecto_final.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    //CRUD Client
    //Create Client
    @PostMapping(path= "/save")
    public ResponseEntity<Object> postClient (@Valid @RequestBody Client client){
        try{
            Client clientSaved = clientService.postClient(client);
            return ResponseHandler.generateResponse(
                    "Client saved successfully",
                    HttpStatus.OK,
                    clientSaved
            );
        } catch (Exception e){
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );

        }
    }

    //Read Client
    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getClient(@PathVariable() int id){
        try{
            Client clientFound = clientService.getClient(id);
            return ResponseHandler.generateResponse(
                    "Client retrieved successfully.",
                    HttpStatus.OK,
                    clientFound
            );
        }catch (Exception e){
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    //Get all clients
    @GetMapping(path = "/allclients")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    //Update Client
    @PutMapping(path="/update")
    public ResponseEntity<Object> updateClient(@RequestBody Client client){
        try{
            Client clientUpdated = clientService.postClient(client);
            return ResponseHandler.generateResponse(
                    "Client updated successfully",
                    HttpStatus.OK,
                    clientUpdated
            );
        } catch (Exception e){
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    //Delete Client
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable() int client_id){
        try{
            Client clientDeleted = clientService.deleteClient(client_id);
            return ResponseHandler.generateResponse(
                    "Client removed successfully",
                    HttpStatus.OK,
                    clientDeleted
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