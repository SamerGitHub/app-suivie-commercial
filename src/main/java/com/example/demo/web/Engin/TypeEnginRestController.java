package com.example.demo.web.Engin;

import com.example.demo.entities.Engin.TypeEngin;
import com.example.demo.service.Engin.TypeEnginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TypeEnginRestController {


    @Autowired
    private TypeEnginService typeEnginService;

    @GetMapping("/typeEngin/classification/{id}")
    public List<TypeEngin> getAllTypeEnginByIdClassEngin(@PathVariable Long id)
    {

        return typeEnginService.getAllTypeEnginByidClassEngin(id);

    }

    @GetMapping("/typeEngin/tache/{type}")
    public List<TypeEngin> getAllTypeEnginByTaskType(@PathVariable String type)
    {

        System.out.println("taskType:::::::"+type);
        return typeEnginService.getAllTypeEnginByTaskType(type);

    }


    @GetMapping("/typeEngin")
    public List<TypeEngin> getAllTypeEngin()
    {
        return typeEnginService.getAllTypeEngin();

    }

    @GetMapping("/typeEngin/{id}")
    public TypeEngin getTypeEngin(@PathVariable Long id)
    {

        TypeEngin e= typeEnginService.getTypeEngin(id);

        return e;
    }

    @PostMapping("/typeEngin")
    public void addTypeEngin(@RequestBody TypeEngin typeEngin)
    {
        typeEnginService.addTypeEngin(typeEngin);
    }

    @PutMapping("/typeEngin")
    public void updateTypeEngin(@RequestBody TypeEngin typeEngin)
    {
        typeEnginService.updateTypeEngin(typeEngin);
    }


    @DeleteMapping("/typeEngin/{id}")
    public void deleteTypeEngin(@PathVariable Long id) {
        typeEnginService.deleteTypeEngin(id);
    }
}
