package com.example.demo.dao.Engin;

import com.example.demo.entities.Engin.Modele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ModeleRepository extends JpaRepository<Modele, Long> {

    public Modele getModeleById(Long id);
    public List<Modele> findAllByMarqueId (Long id);
}


