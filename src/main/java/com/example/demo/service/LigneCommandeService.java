package com.example.demo.service;


import com.example.demo.dao.AvoirEnginConducteurRepository;
import com.example.demo.dao.LigneCommandeRepository;
import com.example.demo.entities.LigneCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LigneCommandeService {

    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    @Autowired
    private AvoirEnginConducteurRepository avoirEnginConducteurRepository;

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
        System.out.println("ligneCommande.avoirEnginCond.Id === "+ligneCommande.getAvoirEnginConducteur().getId());

        ligneCommandeRepository.updateStatus(ligneCommande.getId(),ligneCommande.getStatus());

        if(ligneCommande.getStatus().equals("finish"))
            avoirEnginConducteurRepository.updateFinishDate(ligneCommande.getAvoirEnginConducteur().getId(),new Date());

        if(ligneCommande.getStatus().equals("start"))
            avoirEnginConducteurRepository.updateStartDate(ligneCommande.getAvoirEnginConducteur().getId(),new Date());


    }


    public void deleteLigneCommande(Long id) {
        ligneCommandeRepository.deleteById(id);

    }
}
