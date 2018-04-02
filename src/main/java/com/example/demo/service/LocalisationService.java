package com.example.demo.service;

import com.example.demo.dao.LocalisationRepository;
import com.example.demo.entities.Localisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalisationService {

    @Autowired
    private LocalisationRepository localisationRepository;


    public List<Localisation> getAllLocalisation()
    {

        return localisationRepository.findAll();

    }

    public Localisation getLocalisation(Long id)
    {
        return localisationRepository.getLocalisationById(id);
    }

    public void addLocalisation(Localisation localisation) {

        localisationRepository.save(localisation);

    }

    public void updateLocalisation(Long id, Localisation localisation) {


        localisationRepository.save(localisation);

    }

    public void deleteLocalisation(Long id) {
        localisationRepository.deleteById(id);

    }
}
