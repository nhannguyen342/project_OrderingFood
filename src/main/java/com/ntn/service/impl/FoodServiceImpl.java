/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntn.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ntn.pojos.Food;
import com.ntn.repository.FoodRepository;
import com.ntn.service.FoodService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ACER
 */
@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Food> getFoods(String kw, int page) {
        return this.foodRepository.getFoods(kw, page);
    }

    @Override
    public boolean addOrUpdate(Food food) {
        try {
            Map r = this.cloudinary.uploader().upload(food.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            food.setImage((String) r.get("secure_url"));
            
            return this.foodRepository.addOrUpdate(food);
        } catch (IOException ex) {
            System.err.println("==ADD FOOD ==" + ex.getMessage());
        }
        
        return false;
    }

    @Override
    public long countFood() {
        return this.foodRepository.countProduct();
    }

    @Override
    public Food getFoodById(int i) {
        return this.foodRepository.getFoodById(i);
    }

}
