package com.example.demo.dao.Engin;

import com.example.demo.entities.Engin.Reparation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReparationRepository  extends JpaRepository<Reparation, Long> {
    public Reparation getReparationById(Long id);
}
