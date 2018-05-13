package com.example.demo.dao;

import com.example.demo.entities.AvoirEnginConducteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvoirEnginConducteurRepository extends JpaRepository<AvoirEnginConducteur,Long> {

    public AvoirEnginConducteur getAvoirEnginConducteurById(Long id);
    public AvoirEnginConducteur getAvoirEnginConducteurByLigneCommandeId(Long id);
}
