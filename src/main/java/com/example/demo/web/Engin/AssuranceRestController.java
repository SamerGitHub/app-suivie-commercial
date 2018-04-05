package com.example.demo.web.Engin;

import com.example.demo.entities.Engin.Assurance;
import com.example.demo.service.Engin.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssuranceRestController {

    @Autowired
    private AssuranceService assuranceService;

    @GetMapping("/assurance")
    public List<Assurance> getAllAssurance()
    {
        return assuranceService.getAllAssurance();

    }


    @GetMapping("/assurance/{id}")
    public Assurance getAssurance(@PathVariable Long id)
    {

        Assurance e= assuranceService.getAssurance(id);

        return e;
    }

    @PostMapping("/assurance")
    public void addAssurance(@RequestBody Assurance assurance)
    {
        assuranceService.addAssurance(assurance);
    }

    @PutMapping("/assurance")
    public void updateAssurance(@RequestBody Assurance assurance)
    {
        assuranceService.updateAssurance(assurance);
    }


    @DeleteMapping("/assurance/{id}")
    public void deleteAssurance(@PathVariable Long id)
    {
        assuranceService.deleteAssurance(id);
    }
}
