package com.example.demo.service.Engin;


import com.example.demo.Exception.EnginNotFoundException;
import com.example.demo.dao.Engin.ClassEnginRepository;
import com.example.demo.dao.Engin.EnginRepository;
import com.example.demo.dao.LocalisationRepository;
import com.example.demo.entities.Engin.ClassEngin;
import com.example.demo.entities.Engin.Engin;
import com.example.demo.entities.Localisation;
import com.example.demo.service.StorageService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ServerErrorException;

import java.util.List;

@Service
public class EnginService {
    @Autowired
    private StorageService storageService;
    @Autowired
    private EnginRepository enginRepository;
    @Autowired
    private LocalisationRepository localisationRepository;
    @Autowired
    private ClassEnginRepository classEnginRepository;


    public Engin getEnginByMatricule(String matricule) {
        return enginRepository.getEnginByMatricule(matricule);
    }

    public List<Engin> getAllEngin() {

        return enginRepository.findAll();

    }

    public Engin getEngin(Long id) {
        return enginRepository.getEnginById(id);
    }

    public void addEngin(Engin engin) {

        Engin e = enginRepository.getEnginByMatricule(engin.getMatricule());
        if (e != null) {
            throw new ServerErrorException("engin exite deja");

        }
        System.out.println("after exep");
        engin.setId(null);
        engin.getLocalisation().setId(null);
        enginRepository.save(engin);

/*
        if(engin.getClasEngin()==null)throw new RuntimeException("ClassEngin Not found in body");
        if (engin.getClasEngin().getType() == null)
            throw new RuntimeException("Type ClassEngin Not found in body");
        if (engin.getClasEngin().getClassificaton() == null)
            throw new RuntimeException("Classification ClassEngin Not found in body");


        ClassEngin ce = classEnginRepository.getClassEnginByClassificatonAndType(engin.getClasEngin().getClassificaton(), engin.getClasEngin().getType());


        if (ce != null) {
            engin.setLocalisation(localisationRepository.save(new Localisation(0f, 0f)));
            engin.setClasEngin(ce);
            enginRepository.save(engin);
        } else {
            throw new RuntimeException("Classification Not Exist in DB");

        }
*/

    }

    public void updateEngin(Engin engin) {
        Engin e = enginRepository.getEnginById(engin.getId());
        if (e != null) {
            if (engin.getModele() == null)

                throw new RuntimeException("model Not found in body");


            if (engin.getModele().getId() == null)
                throw new RuntimeException("modele.id Not found in body");

            //  engin.setLocalisation(e.getLocalisation());
            enginRepository.save(engin);

        } else {
            throw new RuntimeException("engin id Not found in BD");
        }
/*
        Engin e=enginRepository.getEnginById(engin.getId());
        if(e!=null)
        {
            if(engin.getClasEngin()==null)throw new RuntimeException("ClassEngin Not found in body");
            if (engin.getClasEngin().getType() == null)
                throw new RuntimeException("Type ClassEngin Not found in body");
            if (engin.getClasEngin().getClassificaton() == null)
                throw new RuntimeException("Classification ClassEngin Not found in body");
            ClassEngin ce = classEnginRepository.getClassEnginByClassificatonAndType(engin.getClasEngin().getClassificaton(), engin.getClasEngin().getType());

            if(ce==null)throw new RuntimeException("verifiez type et classification");

            engin.setLocalisation(e.getLocalisation());
            enginRepository.save(engin);
            //classEnginRepository.save(engin.getClasEngin());
        }else
            throw new RuntimeException("Engin not found");

*/
    }

    public ResponseEntity<String> UpdatePhoto(Long id, MultipartFile file)
    {

        String message = "";
        try {

            storageService.store(file,"engin");
            enginRepository.updatePhoto(id,file.getOriginalFilename());

            message = "You successfully uploaded " + file.getOriginalFilename() + "!";

            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }


    }
    public void deleteEngin(Long id) {


        Engin e = enginRepository.getEnginById(id);
        if (e != null) {
            enginRepository.deleteById(id);
            localisationRepository.delete(e.getLocalisation());

        } else throw new RuntimeException("Engin not exist");

    }

}
