package com.example.demo.service.Engin;

import com.example.demo.dao.Engin.AssuranceRepository;
import com.example.demo.entities.Engin.Assurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssuranceService {
    @Autowired
    private AssuranceRepository assuranceRepository;


    public List<Assurance> getAllAssurance()
    {

        return assuranceRepository.findAll();

    }

    public Assurance getAssurance(Long id)
    {
        return assuranceRepository.getAssuranceById(id);
    }

    public void addAssurance(Assurance assurance) {

        assuranceRepository.save(assurance);

    }

    public void updateAssurance(Assurance assurance) {

        assuranceRepository.save(assurance);

    }

    public void deleteAssurance(Long id) {
        assuranceRepository.deleteById(id);

    }
}
