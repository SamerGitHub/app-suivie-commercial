package com.example.demo.dao;


import com.example.demo.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long>{


	public AppUser findByUsername(String Username);

}
