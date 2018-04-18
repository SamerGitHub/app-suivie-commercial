package com.example.demo.dao.tache;

import com.example.demo.entities.tache.Livraison;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface LivraisonRepository extends TaskBaseRepository<Livraison>{

}
