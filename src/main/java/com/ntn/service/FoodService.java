/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ntn.service;

import com.ntn.pojos.Food;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface FoodService {
    List<Food> getFoods(String kw, int page);
    long countFood();
    Food getFoodById(int id);
    boolean addOrUpdate(Food food);
}
