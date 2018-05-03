package com.example.demo.service.Engin;

import com.example.demo.dao.Engin.CompagnieAssuranceRepository;
import com.example.demo.entities.Engin.CompagnieAssurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompagnieAssuranceService {

    @Autowired
    private CompagnieAssuranceRepository compagnieAssuranceRepository;



    public List<CompagnieAssurance> getAllCompagnieAssurance()
    {

        return compagnieAssuranceRepository.findAll();

    }

    public CompagnieAssurance getCompagnieAssurance(Long id)
    {
        return compagnieAssuranceRepository.getCompagnieAssuranceById(id);
    }

    public void addCompagnieAssurance(CompagnieAssurance compagnieAssurance) {

        //  compagnieAssurance.setLocalisation(localisationRepository.save(compagnieAssurance.getLocalisation()));
        compagnieAssuranceRepository.save(compagnieAssurance);

    }

    public void updateCompagnieAssurance(CompagnieAssurance compagnieAssurance) {


        compagnieAssuranceRepository.save(compagnieAssurance);

    }

    public void deleteCompagnieAssurance(Long id) {
        compagnieAssuranceRepository.deleteById(id);

    }
}
