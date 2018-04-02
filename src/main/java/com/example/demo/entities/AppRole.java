package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class AppRole {
	@Id @GeneratedValue
	private Long id;
	private String roleName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public AppRole(Long id, String roleName) {
		
		this.id = id;
		this.roleName = roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleName() {
		return roleName;
	}
	public AppRole() {
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AppRole{" +
				"id=" + id +
				", roleName='" + roleName + '\'' +
				'}';
	}
}
