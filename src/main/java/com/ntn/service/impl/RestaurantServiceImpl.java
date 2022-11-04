/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntn.service.impl;

import com.ntn.pojos.Restaurant;
import com.ntn.repository.RestaurantRepository;
import com.ntn.service.RestaurantService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    
    @Override
    public List<Restaurant> getRestaurants() {
        return this.restaurantRepository.getRestaurants();
    } 

    @Override
    public Restaurant getRestaurantById(int restId) {
        return this.restaurantRepository.getRestaurantById(restId);
    }
}
