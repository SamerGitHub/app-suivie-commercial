package com.example.demo.service;

import com.example.demo.dao.CommandeRepository;
import com.example.demo.entities.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public List<Commande> getAllCommande()
    {

        return commandeRepository.findAll();

    }

    public Commande getCommande(Long id)
    {
        return commandeRepository.getCommandeById(id);
    }

    public void addCommande(Commande commande) {

        commande.setId(null);
        commandeRepository.save(commande);

    }

    public void updateCommande(Commande commande) {


        commandeRepository.save(commande);

    }

    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);

    }
}
