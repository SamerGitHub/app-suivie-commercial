package com.example.demo.service.Engin;

import com.example.demo.dao.Engin.LigneReparationRepository;
import com.example.demo.entities.Engin.LigneReparation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneReparationService {
    @Autowired
    private LigneReparationRepository ligneReparationRepository;


    public List<LigneReparation> getAllLigneReparation()
    {

        return ligneReparationRepository.findAll();

    }

    public LigneReparation getLigneReparation(Long id)
    {
        return ligneReparationRepository.getLigneReparationById(id);
    }

    public void addLigneReparation(LigneReparation ligneReparation) {

        ligneReparationRepository.save(ligneReparation);

    }

    public void updateLigneReparation(LigneReparation ligneReparation) {

        ligneReparationRepository.save(ligneReparation);

    }

    public void deleteLigneReparation(Long id) {
        ligneReparationRepository.deleteById(id);

    }
}
