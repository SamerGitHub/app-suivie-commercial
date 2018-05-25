package com.example.demo.dao;

import com.example.demo.entities.AvoirEnginConducteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public interface AvoirEnginConducteurRepository extends JpaRepository<AvoirEnginConducteur,Long> {

    public AvoirEnginConducteur getAvoirEnginConducteurById(Long id);
    public AvoirEnginConducteur getAvoirEnginConducteurByLigneCommandeId(Long id);


    @Modifying(clearAutomatically = true)
    @Query("select u from AvoirEnginConducteur u where (u.conducteur.username = :username and u.ligneCommande.status = :status1) OR (u.conducteur.username = :username and u.ligneCommande.status = :status2)")
    public List<AvoirEnginConducteur> findByConducteurUsernameAndLigneCommandeStatus(@Param("username") String username,@Param("status1") String status1,@Param("status2") String status2);



    public List<AvoirEnginConducteur> findAllByConducteurUsername (String username);


}
