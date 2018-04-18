package com.example.demo.dao.tache;

import com.example.demo.entities.tache.Remblaiment;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RemblaimentRepository  extends TaskBaseRepository<Remblaiment> {

}
