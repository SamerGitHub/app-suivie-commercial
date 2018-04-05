package com.example.demo.service.Engin;

import com.example.demo.dao.Engin.VidangeRepository;
import com.example.demo.entities.Engin.Vidange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VidangeService {


        @Autowired
        private VidangeRepository vidangeRepository;


        public List<Vidange> getAllVidange()
        {

            return vidangeRepository.findAll();

        }

    public Vidange getVidange(Long id)
    {
        return vidangeRepository.getVidangeById(id);
    }

    public void addVidange(Vidange vidange) {

        vidangeRepository.save(vidange);

    }

    public void updateVidange(Vidange vidange) {

        vidangeRepository.save(vidange);

    }

    public void deleteVidange(Long id) {
        vidangeRepository.deleteById(id);

    }
}
