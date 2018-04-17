package com.example.demo.dao.Engin;

import com.example.demo.entities.Engin.LigneReparation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneReparationRepository extends JpaRepository<LigneReparation,Long>{
    public LigneReparation getLigneReparationById(Long id);
}
