package com.example.demo.web;

import com.example.demo.entities.Client;
import com.example.demo.service.ClientService;
import com.example.demo.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ClientRestController {
    @Autowired
    private ClientService clientService;
    @Autowired
    StorageService storageService;

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
    public  Client addClient(@RequestBody Client client)
    {

        return clientService.addClient(client);

    }
    @PostMapping("/client/add/photo")
    public  ResponseEntity<String> addPhoto(@RequestParam("file") MultipartFile file)
    {

        String message = "";
     try {

            storageService.store(file,"client");

            message = "You successfully uploaded " + file.getOriginalFilename() + "!";

            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }


    }
    @PutMapping("/client/{id}/update/photo")
    public  ResponseEntity<String> UpdatePhoto(@PathVariable Long id,@RequestParam("file") MultipartFile file)
    {

          return clientService.UpdatePhoto(id,file);


    }

    @GetMapping("/client/photo/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.loadFile(filename,"client");
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
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
