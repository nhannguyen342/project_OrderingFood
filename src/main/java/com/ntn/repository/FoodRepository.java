/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ntn.repository;

import com.ntn.pojos.Food;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface FoodRepository {
    List<Food> getFoods(String kw, int page);
    Food getFoodById(int foodId);
    long countProduct();
    boolean addOrUpdate(Food food);
    
}
