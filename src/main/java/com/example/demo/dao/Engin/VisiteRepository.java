package com.example.demo.dao.Engin;

import com.example.demo.entities.Engin.Visite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisiteRepository  extends JpaRepository<Visite, Long> {
    public Visite getVisiteById(Long id);
}
