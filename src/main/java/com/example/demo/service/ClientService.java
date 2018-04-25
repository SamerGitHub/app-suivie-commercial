package com.example.demo.service;

import com.example.demo.dao.ClientRepository;
import com.example.demo.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    StorageService storageService;

    public List<Client> getAllClient()
    {

        return clientRepository.findAll();

    }

    public Client getClient(Long id)
    {
        return clientRepository.getClientById(id);
    }

    public Client addClient(Client client) {

        client.setId(null);
        return clientRepository.save(client);

    }

    public void updateClient(Client client) {


        clientRepository.save(client);

    }
    public ResponseEntity<String> UpdatePhoto(Long id,MultipartFile file)
    {

        String message = "";
        try {

            storageService.store(file,"client");
            clientRepository.updatePhoto(id,file.getOriginalFilename());

            message = "You successfully uploaded " + file.getOriginalFilename() + "!";

            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }


    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);

    }
}
