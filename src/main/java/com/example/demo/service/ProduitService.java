package com.example.demo.service;

import com.example.demo.dao.ProduitRepository;
import com.example.demo.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getAllProduit()
    {

        return produitRepository.findAll();

    }

    public Produit getProduit(Long id)
    {
        return produitRepository.getProduitById(id);
    }

    public void addProduit(Produit produit) {

        produit.setId(null);
        produitRepository.save(produit);

    }

    public void updateProduit(Produit produit) {


        produitRepository.save(produit);

    }

    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);

    }
}
