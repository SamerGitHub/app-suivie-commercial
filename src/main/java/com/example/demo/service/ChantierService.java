package com.example.demo.service;

import com.example.demo.dao.ChantierRepository;
import com.example.demo.dao.LocalisationRepository;
import com.example.demo.entities.Chantier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChantierService {

    @Autowired
    private ChantierRepository chantierRepository;
    @Autowired
    private LocalisationRepository localisationRepository;


    public List<Chantier> getAllChantier()
    {

        return chantierRepository.findAll();

    }

    public Chantier getChantier(Long id)
    {
        return chantierRepository.getChantierById(id);
    }

    public void addChantier(Chantier chantier) {

      //  chantier.setLocalisation(localisationRepository.save(chantier.getLocalisation()));
        chantierRepository.save(chantier);

    }

    public void updateChantier(Chantier chantier) {


        chantierRepository.save(chantier);

    }

    public void deleteChantier(Long id) {
        chantierRepository.deleteById(id);

    }
}
