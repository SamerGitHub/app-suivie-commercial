package com.example.demo.service.Engin;

import com.example.demo.dao.Engin.LigneReparationRepository;
import com.example.demo.dao.Engin.ReparationRepository;
import com.example.demo.entities.Engin.LigneReparation;
import com.example.demo.entities.Engin.Reparation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReparationService {
    @Autowired
    private ReparationRepository reparationRepository;
    @Autowired
    private LigneReparationRepository ligneReparationRepository;

    public List<Reparation> getAllReparation()
    {

        return reparationRepository.findAll();

    }

    public Reparation getReparation(Long id)
    {
        return reparationRepository.getReparationById(id);
    }

    public void addReparation(Reparation reparation) {
        reparation.setId(null);
        Reparation r=reparationRepository.save(reparation);
       for (LigneReparation lr :reparation.getLigneReparations())
       {
           lr.setId(null);
           lr.setReparation(r);
           ligneReparationRepository.save(lr);
       }

    }

    public void updateReparation(Reparation reparation) {

        reparationRepository.save(reparation);

    }

    public void deleteReparation(Long id) {
        reparationRepository.deleteById(id);

    }
}
