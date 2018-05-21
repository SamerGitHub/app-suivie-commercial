package com.example.demo.dao;

import com.example.demo.entities.Commande;
import com.example.demo.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface LigneCommandeRepository  extends JpaRepository<LigneCommande, Long> {
    public LigneCommande getLigneCommandeById(Long id);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE LigneCommande l SET l.status =:status WHERE l.id =:id")
    public void updateStatus(@Param("id")Long id, @Param("status")String status );

}
