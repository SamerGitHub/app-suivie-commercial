package com.example.demo.web.Engin;

import com.example.demo.entities.Engin.Engin;
import com.example.demo.service.Engin.EnginService;
import com.example.demo.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class EnginRestController {

    @Autowired
    private EnginService enginService;

    @Autowired
    StorageService storageService;

    @GetMapping("/engin/matricule/{matricule}")
    public Engin getEnginByMatricule(@PathVariable String matricule)
    {

        Engin e= enginService.getEnginByMatricule(matricule);

        return e;
    }

    @GetMapping("/engin")
    public List<Engin> getAllEngin()
    {
        return enginService.getAllEngin();

    }


    @GetMapping("/engin/{id}")
    public Engin getEngin(@PathVariable Long id)
    {

        Engin e= enginService.getEngin(id);

        return e;
    }

    @PostMapping("/engin")
    public void addEngin(@RequestBody Engin engin)
    {
        enginService.addEngin(engin);
    }


    @PostMapping("/engin/add/photo")
    public ResponseEntity<String> addPhoto(@RequestParam("file") MultipartFile file)
    {

        String message = "";
        try {

            storageService.store(file,"engin");

            message = "You successfully uploaded " + file.getOriginalFilename() + "!";

            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }


    }

    @PutMapping("/engin/{id}/update/photo")
    public  ResponseEntity<String> UpdatePhoto(@PathVariable Long id,@RequestParam("file") MultipartFile file)
    {

        return enginService.UpdatePhoto(id,file);


    }

    @GetMapping("/engin/photo/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.loadFile(filename,"engin");
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @PutMapping("/engin")
    public void updateEngin(@RequestBody Engin engin)
    {
        enginService.updateEngin(engin);
    }


    @DeleteMapping("/engin/{id}")
    public void deleteEngin(@PathVariable Long id)
    {
        enginService.deleteEngin(id);
    }
}
