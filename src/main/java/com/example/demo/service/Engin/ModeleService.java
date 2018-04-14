package com.example.demo.service.Engin;


import com.example.demo.dao.Engin.ModeleRepository;
import com.example.demo.entities.Engin.Modele;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeleService {

    @Autowired
    private ModeleRepository modeleRepository;

    public List<Modele> getAllModeleByidMarque(Long id)
    {

        return modeleRepository.findAllByMarqueId(id);

    }

    public List<Modele> getAllModele()
    {

        return modeleRepository.findAll();

    }

    public Modele getModele(Long id)
    {
        return modeleRepository.getModeleById(id);
    }

    public void addModele(Modele modele) {

        modeleRepository.save(modele);

    }

    public void updateModele(Modele modele) {

        modeleRepository.save(modele);

    }

    public void deleteModele(Long id) {
        modeleRepository.deleteById(id);

    }
}
