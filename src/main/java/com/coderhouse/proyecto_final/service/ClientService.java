package com.coderhouse.proyecto_final.service;

import com.coderhouse.proyecto_final.model.Client;
import com.coderhouse.proyecto_final.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    //Save a client
    public Client postClient(Client client) throws Exception{
        return clientRepository.save(client);
    }

    //Get a client
    public Client getClient(int client_id) throws Exception{
        Optional<Client> client = clientRepository.findById(client_id);
        if(client.isEmpty()){
            throw new Exception("Client with id: " + client_id + " not found.");
        }else{
            return client.get();
        }
    }

    //Get all clients
    public List<Client> getAllClients() {
        List<Client> clientList = clientRepository.findAll();
        return clientList;
    }

    //Update a client
    public Client updateClient(Client client) throws Exception{
        return clientRepository.save(client);
    }

    //Delete a client
    public Client deleteClient(int client_id) throws Exception{
        Optional<Client> client = clientRepository.findById(client_id);
        if(client.isEmpty()){
            throw new Exception("Client with id: " + client_id + " not found.");
        }else{
            clientRepository.deleteById(client_id);
        }
        return null;
    }
}