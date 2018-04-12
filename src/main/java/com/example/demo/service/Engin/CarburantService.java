package com.example.demo.service.Engin;

import com.example.demo.dao.Engin.CarburantRepository;
import com.example.demo.entities.Engin.Carburant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarburantService {

    @Autowired
    private CarburantRepository carburantRepository;


    public List<Carburant> getAllCarburant()
    {

        return carburantRepository.findAll();

    }

    public Carburant getCarburant(Long id)
    {
        return carburantRepository.getCarburantById(id);
    }

    public void addCarburant(Carburant carburant) {

        carburantRepository.save(carburant);

    }

    public void updateCarburant(Carburant carburant) {

        carburantRepository.save(carburant);

    }

    public void deleteCarburant(Long id) {
        carburantRepository.deleteById(id);

    }
}
