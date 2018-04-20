package com.example.demo.service.Engin;

import com.example.demo.dao.Engin.TypeEnginRepository;
import com.example.demo.entities.Engin.TypeEngin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeEnginService {

    @Autowired
    private TypeEnginRepository typeEnginRepository;


    public List<TypeEngin> getAllTypeEnginByTaskType(String taskType)
    {

        if(taskType.equals("Livraison"))

        return typeEnginRepository.findAllByClasEnginClassification("Engins de transports");

        else if (taskType.equals("creuseEtFondation"))
        {
            return typeEnginRepository.findAllByClasEnginClassification("Engins de chargements");
        }
        return  null;
    }





    public List<TypeEngin> getAllTypeEnginByidClassEngin(Long id)
    {

        return typeEnginRepository.findAllByClasEnginId(id);

    }








    public List<TypeEngin> getAllTypeEngin()
    {

        return typeEnginRepository.findAll();

    }

    public TypeEngin getTypeEngin(Long id)
    {
        return typeEnginRepository.getTypeEnginById(id);
    }

    public void addTypeEngin(TypeEngin typeEngin) {

        typeEnginRepository.save(typeEngin);

    }

    public void updateTypeEngin(TypeEngin typeEngin) {

        typeEnginRepository.save(typeEngin);

    }

    public void deleteTypeEngin(Long id) {
        typeEnginRepository.deleteById(id);

    }
}
