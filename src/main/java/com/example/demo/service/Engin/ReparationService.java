package com.example.demo.service.Engin;

import com.example.demo.dao.Engin.ReparationRepository;
import com.example.demo.entities.Engin.Reparation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReparationService {
    @Autowired
    private ReparationRepository reparationRepository;


    public List<Reparation> getAllReparation()
    {

        return reparationRepository.findAll();

    }

    public Reparation getReparation(Long id)
    {
        return reparationRepository.getReparationById(id);
    }

    public void addReparation(Reparation reparation) {

        reparationRepository.save(reparation);

    }

    public void updateReparation(Reparation reparation) {

        reparationRepository.save(reparation);

    }

    public void deleteReparation(Long id) {
        reparationRepository.deleteById(id);

    }
}
