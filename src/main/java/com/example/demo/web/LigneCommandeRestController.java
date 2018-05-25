package com.example.demo.web;


import com.example.demo.entities.LigneCommande;
import com.example.demo.service.LigneCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LigneCommandeRestController {

    @Autowired
    private LigneCommandeService ligneCommandeService;


    @GetMapping("/ligneCommande")
    public List<LigneCommande> getAllLigneCommande()
    {
        return ligneCommandeService.getAllLigneCommande();

    }


    @GetMapping("/ligneCommande/{id}")
    public LigneCommande getLigneCommande(@PathVariable Long id)
    {

        return ligneCommandeService.getLigneCommande(id);

    }

    @PostMapping("/ligneCommande")
    public void addLigneCommande(@RequestBody LigneCommande ligneCommande)
    {
        ligneCommandeService.addLigneCommande(ligneCommande);
    }

    @PutMapping("/ligneCommande")
    public void updateLigneCommande(@RequestBody LigneCommande ligneCommande)
    {
        ligneCommandeService.updateLigneCommande(ligneCommande);
    }

    @PostMapping("/ligneCommande/update/status")
    public void updateLigneCommandeStatus(@RequestBody LigneCommande ligneCommande)
    {
        System.out.println("/ligneCommande/update/status");
        ligneCommandeService.updateLigneCommandeStatus(ligneCommande);
    }


    @DeleteMapping("/ligneCommande/{id}")
    public void deleteLigneCommande(@PathVariable Long id)
    {
        ligneCommandeService.deleteLigneCommande(id);
    }
}
