package com.example.demo.dao;

import com.example.demo.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeRepository  extends JpaRepository<LigneCommande, Long> {
    public LigneCommande getLigneCommandeById(Long id);

}
