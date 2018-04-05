package com.example.demo.service.Engin;

import com.example.demo.dao.Engin.VisiteRepository;
import com.example.demo.entities.Engin.Visite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisiteService {

    @Autowired
    private VisiteRepository visiteRepository;


    public List<Visite> getAllVisite()
    {

        return visiteRepository.findAll();

    }

    public Visite getVisite(Long id)
    {
        return visiteRepository.getVisiteById(id);
    }

    public void addVisite(Visite visite) {

        visiteRepository.save(visite);

    }

    public void updateVisite(Visite visite) {

        visiteRepository.save(visite);

    }

    public void deleteVisite(Long id) {
        visiteRepository.deleteById(id);

    }
}
