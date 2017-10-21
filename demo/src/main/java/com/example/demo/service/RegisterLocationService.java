/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entities.UserLocation;
import com.example.demo.model.LocationRequest;
import com.example.demo.repository.UserLocationRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author student
 */
@RestController
public class RegisterLocationService {

    @Autowired
    private UserLocationRepository userLocationRepository;

    @RequestMapping(path = "/test")
    public String test() {
        return "I am ok!";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public void getLocation(@RequestBody LocationRequest request) {
        System.out.println("User: " + request.getUsername() + " LAT: " + request.getLatitude() + " LON: " + request.getLongitude());

        UserLocation alreadyExisting = userLocationRepository.findByUsername(request.getUsername());

        if (alreadyExisting != null) {
            alreadyExisting.setLatitude(request.getLatitude());
            alreadyExisting.setLongitude(request.getLongitude());
            alreadyExisting.setData(new Date());
            userLocationRepository.save(alreadyExisting);
        } else {
            UserLocation location = new UserLocation();

            location.setUsername(request.getUsername());
            location.setLatitude(request.getLatitude());
            location.setLongitude(request.getLongitude());
            location.setData(new Date());
            userLocationRepository.save(location);
        }

    }
}
