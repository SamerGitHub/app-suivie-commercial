package com.example.demo.service.Engin;

import com.example.demo.dao.Engin.TaxeRepository;
import com.example.demo.entities.Engin.Taxe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxeService {

    @Autowired
    private TaxeRepository taxeRepository;


    public List<Taxe> getAllTaxe()
    {

        return taxeRepository.findAll();

    }

    public Taxe getTaxe(Long id)
    {
        return taxeRepository.getTaxeById(id);
    }

    public void addTaxe(Taxe taxe) {

        taxeRepository.save(taxe);

    }

    public void updateTaxe(Taxe taxe) {

        taxeRepository.save(taxe);

    }

    public void deleteTaxe(Long id) {
        taxeRepository.deleteById(id);

    }
}
