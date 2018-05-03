package com.example.demo.web.Engin;

import com.example.demo.entities.Engin.CompagnieAssurance;
import com.example.demo.service.Engin.CompagnieAssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompagnieAssuranceRestController {

    @Autowired
    private CompagnieAssuranceService compagnieAssuranceService;

    @GetMapping("/compagnieAssurance")
    public List<CompagnieAssurance> getAllCompagnieAssurance()
    {
        return compagnieAssuranceService.getAllCompagnieAssurance();

    }

    @GetMapping("/compagnieAssurance/{id}")
    public CompagnieAssurance getCompagnieAssurance(@PathVariable Long id)
    {

        CompagnieAssurance e= compagnieAssuranceService.getCompagnieAssurance(id);

        return e;
    }

    @PostMapping("/compagnieAssurance")
    public void addCompagnieAssurance(@RequestBody CompagnieAssurance compagnieAssurance)
    {
        compagnieAssuranceService.addCompagnieAssurance(compagnieAssurance);
    }

    @PutMapping("/compagnieAssurance")
    public void updateCompagnieAssurance(@RequestBody CompagnieAssurance compagnieAssurance)
    {
        compagnieAssuranceService.updateCompagnieAssurance(compagnieAssurance);
    }


    @DeleteMapping("/compagnieAssurance/{id}")
    public void deleteCompagnieAssurance(@PathVariable Long id)
    {
        compagnieAssuranceService.deleteCompagnieAssurance(id);
    }
}
