package com.example.demo.dao;


import com.example.demo.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Transactional
@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>{

    public AppUser getAppUserById(Long id);
	public AppUser findByUsername(String Username);


    @Modifying(clearAutomatically = true)
    @Query("UPDATE AppUser u SET u.deviceToken = null WHERE u.deviceToken =:deviceToken")
    public void deleteDeviceToken(@Param("deviceToken")String deviceToken);


    @Modifying(clearAutomatically = true)
    @Query("UPDATE AppUser u SET u.deviceToken =:deviceToken WHERE u.id =:id")
    public void updateDeviceToken(@Param("id")Long id, @Param("deviceToken")String deviceToken );

}
