package com.example.demo.dao;


import com.example.demo.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<AppRole, Long>{
	public AppRole findRoleByRoleName(String roleName);

}
