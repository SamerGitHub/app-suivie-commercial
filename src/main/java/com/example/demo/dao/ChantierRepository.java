package com.example.demo.dao;

import com.example.demo.entities.Chantier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChantierRepository extends JpaRepository<Chantier, Long> {
    public Chantier getChantierById(Long id);
}
