package com.example.demo.service;


import com.example.demo.dao.LigneCommandeRepository;
import com.example.demo.entities.LigneCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneCommandeService {

    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    public List<LigneCommande> getAllLigneCommande()
    {

        return ligneCommandeRepository.findAll();

    }

    public LigneCommande getLigneCommande(Long id)
    {
        return ligneCommandeRepository.getLigneCommandeById(id);
    }

    public void addLigneCommande(LigneCommande ligneCommande) {

        ligneCommande.setId(null);
        ligneCommandeRepository.save(ligneCommande);

    }

    public void updateLigneCommande(LigneCommande ligneCommande) {


        ligneCommandeRepository.save(ligneCommande);

    }

    public void updateLigneCommandeStatus(LigneCommande ligneCommande) {

        ligneCommandeRepository.updateStatus(ligneCommande.getId(),ligneCommande.getStatus());

    }


    public void deleteLigneCommande(Long id) {
        ligneCommandeRepository.deleteById(id);

    }
}
