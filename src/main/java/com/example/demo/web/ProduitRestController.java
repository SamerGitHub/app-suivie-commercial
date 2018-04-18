package com.example.demo.web;

import com.example.demo.entities.Produit;
import com.example.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitRestController {
    @Autowired
    private ProduitService produitService;


    @GetMapping("/produit")
    public List<Produit> getAllProduit()
    {
        return produitService.getAllProduit();

    }


    @GetMapping("/produit/{id}")
    public Produit getProduit(@PathVariable Long id)
    {

        return produitService.getProduit(id);

    }

    @PostMapping("/produit")
    public void addProduit(@RequestBody Produit produit)
    {
        produitService.addProduit(produit);
    }

    @PutMapping("/produit")
    public void updateProduit(@RequestBody Produit produit)
    {
        produitService.updateProduit(produit);
    }


    @DeleteMapping("/produit/{id}")
    public void deleteProduit(@PathVariable Long id)
    {
        produitService.deleteProduit(id);
    }
}
