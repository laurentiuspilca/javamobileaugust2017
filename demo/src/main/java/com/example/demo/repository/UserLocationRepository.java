/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.entities.UserLocation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author student
 */
public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
     
    @Query("SELECT u FROM UserLocation u")
    public List<UserLocation> getAllLocations();
    
    @Query("SELECT u FROM UserLocation u WHERE u.username = :username")
    public UserLocation findByUsername(@Param("username")  String username);
}
