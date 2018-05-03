package com.example.demo.dao.Engin;


import com.example.demo.entities.Engin.CompagnieAssurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompagnieAssuranceRepository extends JpaRepository<CompagnieAssurance, Long> {
    public CompagnieAssurance getCompagnieAssuranceById(Long id);
}
