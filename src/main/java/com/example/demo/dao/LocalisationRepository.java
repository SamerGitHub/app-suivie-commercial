package com.example.demo.dao;

import com.example.demo.entities.Localisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalisationRepository  extends JpaRepository<Localisation, Long> {

    public Localisation getLocalisationById(Long id);


}
