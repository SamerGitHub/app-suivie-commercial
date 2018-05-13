package com.example.demo.service;


import com.example.demo.dao.AvoirEnginConducteurRepository;
import com.example.demo.entities.AvoirEnginConducteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvoirEnginConducteurService {
    @Autowired
    private AvoirEnginConducteurRepository avoirEnginConducteurRepository;

    public List<AvoirEnginConducteur> getAllAvoirEnginConducteur()
    {

        return avoirEnginConducteurRepository.findAll();

    }

    public AvoirEnginConducteur getAvoirEnginConducteur(Long id)
    {
        return avoirEnginConducteurRepository.getAvoirEnginConducteurById(id);
    }

    public AvoirEnginConducteur getAvoirEnginConducteurByIdLigneCommande(Long id)
    {
        return avoirEnginConducteurRepository.getAvoirEnginConducteurByLigneCommandeId(id);
    }
    public void addAvoirEnginConducteur(AvoirEnginConducteur avoirEnginConducteur) {

        avoirEnginConducteur.setId(null);
        avoirEnginConducteurRepository.save(avoirEnginConducteur);

    }

    public void updateAvoirEnginConducteur(AvoirEnginConducteur avoirEnginConducteur) {


        avoirEnginConducteurRepository.save(avoirEnginConducteur);

    }

    public void deleteAvoirEnginConducteur(Long id) {
        avoirEnginConducteurRepository.deleteById(id);

    }
}
