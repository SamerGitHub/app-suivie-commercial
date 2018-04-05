package com.example.demo.web.Engin;

import com.example.demo.dao.Engin.VidangeRepository;
import com.example.demo.entities.Engin.Vidange;
import com.example.demo.service.Engin.VidangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class VidangeRestController {
    @Autowired
    private VidangeService vidangeService;

    @GetMapping("/vidange")
    public List<Vidange> getAllVidange()
    {
        return vidangeService.getAllVidange();

    }


    @GetMapping("/vidange/{id}")
    public Vidange getVidange(@PathVariable Long id)
    {

        Vidange e= vidangeService.getVidange(id);

        return e;
    }

    @PostMapping("/vidange")
    public void addVidange(@RequestBody Vidange vidange)
    {
        vidangeService.addVidange(vidange);
    }

    @PutMapping("/vidange")
    public void updateVidange(@RequestBody Vidange vidange)
    {
        vidangeService.updateVidange(vidange);
    }


    @DeleteMapping("/vidange/{id}")
    public void deleteVidange(@PathVariable Long id)
    {
        vidangeService.deleteVidange(id);
    }
}
