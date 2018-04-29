package com.example.demo.dao;

import com.example.demo.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommandeRepository  extends JpaRepository<Commande, Long> {
    public Commande getCommandeById(Long id);
    public List<Commande> getCommandeByChantierId(Long id);

}


