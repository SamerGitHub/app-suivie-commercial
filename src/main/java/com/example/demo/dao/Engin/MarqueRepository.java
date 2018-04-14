package com.example.demo.dao.Engin;

import com.example.demo.entities.Engin.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarqueRepository extends JpaRepository<Marque, Long> {
    public Marque getMarqueById(Long id);
    public List<Marque> findAllByTypeEnginId (Long id);
}
