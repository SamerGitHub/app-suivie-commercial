package com.example.demo.service;

import com.example.demo.dao.ChantierRepository;
import com.example.demo.dao.LocalisationRepository;
import com.example.demo.entities.Chantier;
import com.example.demo.entities.Localisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

        chantier.setId(null);
        chantier.getLocalisation().setId(null);

        chantier.setCreatedDate(new Date());
        chantierRepository.save(chantier);

    }

    public void updateChantier(Chantier chantier) {

         if(chantier.getId()!=null && chantier.getLocalisation().getId()!=null)
         chantierRepository.save(chantier);
          else throw new RuntimeException("verifiez idChantier et idLocalisation");
    }

    public void deleteChantier(Long id) {
        chantierRepository.deleteById(id);

    }
}
