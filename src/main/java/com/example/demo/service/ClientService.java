package com.example.demo.service;

import com.example.demo.dao.ClientRepository;
import com.example.demo.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClient()
    {

        return clientRepository.findAll();

    }

    public Client getClient(Long id)
    {
        return clientRepository.getClientById(id);
    }

    public void addClient(Client client) {

        client.setId(null);
        clientRepository.save(client);

    }

    public void updateClient(Client client) {


        clientRepository.save(client);

    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);

    }
}
