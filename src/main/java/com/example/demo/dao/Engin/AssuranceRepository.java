package com.example.demo.dao.Engin;

import com.example.demo.entities.Engin.Assurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssuranceRepository  extends JpaRepository<Assurance, Long> {
    public Assurance getAssuranceById(Long id);
}
