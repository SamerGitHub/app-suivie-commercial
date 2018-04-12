package com.example.demo.web.Engin;

import com.example.demo.entities.Engin.Carburant;
import com.example.demo.service.Engin.CarburantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarburantRestController {

    @Autowired
    private CarburantService carburantService;

    @GetMapping("/carburant")
    public List<Carburant> getAllCarburant()
    {
        return carburantService.getAllCarburant();

    }


    @GetMapping("/carburant/{id}")
    public Carburant getCarburant(@PathVariable Long id)
    {

        Carburant e= carburantService.getCarburant(id);

        return e;
    }

    @PostMapping("/carburant")
    public void addCarburant(@RequestBody Carburant carburant)
    {
        carburantService.addCarburant(carburant);
    }

    @PutMapping("/carburant")
    public void updateCarburant(@RequestBody Carburant carburant)
    {
        carburantService.updateCarburant(carburant);
    }


    @DeleteMapping("/carburant/{id}")
    public void deleteCarburant(@PathVariable Long id)
    {
        carburantService.deleteCarburant(id);
    }
}
