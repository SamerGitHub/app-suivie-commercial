package com.example.demo.dao;

import com.example.demo.entities.AvoirEnginConducteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvoirEnginConducteurRepository extends JpaRepository<AvoirEnginConducteur,Long> {

    public AvoirEnginConducteur getAvoirEnginConducteurById(Long id);
    public AvoirEnginConducteur getAvoirEnginConducteurByLigneCommandeId(Long id);


    public List<AvoirEnginConducteur> findAllByConducteurUsername (String username);


}
