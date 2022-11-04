/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ntn.repository;

import com.ntn.pojos.Restaurant;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface RestaurantRepository {
    List<Restaurant> getRestaurants();
    Restaurant getRestaurantById(int restId);
}
