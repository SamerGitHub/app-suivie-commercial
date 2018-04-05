package com.example.demo.web.Engin;

import com.example.demo.entities.Engin.Taxe;
import com.example.demo.service.Engin.TaxeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TaxeRestController {

    @Autowired
    private TaxeService taxeService;

    @GetMapping("/taxe")
    public List<Taxe> getAllTaxe()
    {
        return taxeService.getAllTaxe();

    }


    @GetMapping("/taxe/{id}")
    public Taxe getTaxe(@PathVariable Long id)
    {

        Taxe e= taxeService.getTaxe(id);

        return e;
    }

    @PostMapping("/taxe")
    public void addTaxe(@RequestBody Taxe taxe)
    {
        taxeService.addTaxe(taxe);
    }

    @PutMapping("/taxe")
    public void updateTaxe(@RequestBody Taxe taxe)
    {
        taxeService.updateTaxe(taxe);
    }


    @DeleteMapping("/taxe/{id}")
    public void deleteTaxe(@PathVariable Long id)
    {
        taxeService.deleteTaxe(id);
    }
}
