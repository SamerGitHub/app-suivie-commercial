package com.example.demo.web;

import com.example.demo.entities.Commande;
import com.example.demo.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommandeRestController {

    @Autowired
    private CommandeService commandeService;


    @GetMapping("/commande")
    public List<Commande> getAllCommande()
    {
        return commandeService.getAllCommande();

    }
    @GetMapping("/commande/chantier/{id}")
    public List<Commande> getAllCommandebyChantierId(@PathVariable Long id)
    {
        return commandeService.getAllCommandeByChantierId(id);

    }

    @GetMapping("/commande/{id}")
    public Commande getCommande(@PathVariable Long id)
    {

        return commandeService.getCommande(id);

    }

    @PostMapping("/commande")
    public void addCommande(@RequestBody Commande commande)
    {
        System.out.println("addd Commande");

        commandeService.addCommande(commande);
    }

    @PutMapping("/commande")
    public void updateCommande(@RequestBody Commande commande)
    {
        commandeService.updateCommande(commande);
    }


    @DeleteMapping("/commande/{id}")
    public void deleteCommande(@PathVariable Long id)
    {
        commandeService.deleteCommande(id);
    }
}
