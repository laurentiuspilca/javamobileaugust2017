/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entities.UserLocation;
import com.example.demo.repository.UserLocationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author student
 */
@RestController
public class FindLocationsService {
    
    @Autowired
    private UserLocationRepository userLocationRepository;

    @RequestMapping(path = "/list")
    public List<UserLocation> test() {
        return userLocationRepository.getAllLocations();
    }
    
}
