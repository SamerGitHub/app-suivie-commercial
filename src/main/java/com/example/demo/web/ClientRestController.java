package com.example.demo.web;

import com.example.demo.entities.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientRestController {
    @Autowired
    private ClientService clientService;


    @GetMapping("/client")
    public List<Client> getAllClient()
    {
        return clientService.getAllClient();

    }


    @GetMapping("/client/{id}")
    public Client getClient(@PathVariable Long id)
    {

        return clientService.getClient(id);

    }

    @PostMapping("/client")
    public void addClient(@RequestBody Client client)
    {
        clientService.addClient(client);
    }

    @PutMapping("/client")
    public void updateClient(@RequestBody Client client)
    {
        clientService.updateClient(client);
    }


    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable Long id)
    {
        clientService.deleteClient(id);
    }
}
