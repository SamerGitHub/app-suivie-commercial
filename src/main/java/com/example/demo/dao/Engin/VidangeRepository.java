package com.example.demo.dao.Engin;

import com.example.demo.entities.Engin.Vidange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VidangeRepository  extends JpaRepository<Vidange, Long> {
    public Vidange getVidangeById(Long id);
}
