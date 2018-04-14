package com.example.demo.service.Engin;

import com.example.demo.dao.Engin.MarqueRepository;
import com.example.demo.entities.Engin.Marque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarqueService {

    @Autowired
    private MarqueRepository marqueRepository;

    public List<Marque> getAllMarqueByidtypeEngin(Long id)
    {

        return marqueRepository.findAllByTypeEnginId(id);

    }

    public List<Marque> getAllMarque()
    {

        return marqueRepository.findAll();

    }

    public Marque getMarque(Long id)
    {
        return marqueRepository.getMarqueById(id);
    }

    public void addMarque(Marque marque) {

        marqueRepository.save(marque);

    }

    public void updateMarque(Marque marque) {

        marqueRepository.save(marque);

    }

    public void deleteMarque(Long id) {
        marqueRepository.deleteById(id);

    }
}
