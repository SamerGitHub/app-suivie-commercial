package com.example.demo.dao;

import com.example.demo.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    public Client getClientById(Long id);


    @Modifying(clearAutomatically = true)
    @Query("UPDATE Client c SET c.photo =:image WHERE c.id =:id")
    public void updatePhoto( @Param("id")Long id,@Param("image")String photo );
}

