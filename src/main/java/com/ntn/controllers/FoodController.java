/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntn.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ntn.pojos.Food;
import com.ntn.service.FoodService;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.ntn.validator.FoodNameValidator;
import com.ntn.validator.WebAppValidator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author ACER
 */
@Controller
public class FoodController {
    @Autowired
    private WebAppValidator foodValidator;
    @Autowired
    private FoodService foodService;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(foodValidator);
    }
    
    @GetMapping("/restaurant/foods")
    public String list(Model model) {
        model.addAttribute("food", new Food());
        return "food";
    }
    
    @PostMapping("/restaurant/foods")
    public String add(Model model, @ModelAttribute(value = "food") @Valid Food food, 
            BindingResult result) {
        
        if (!result.hasErrors()) {
            if(this.foodService.addOrUpdate(food) == true)
                return "redirect:/";
            else
                model.addAttribute("errMsg", "Somthing wrong!!!");
        }
        return "food"; 
    }
    
    @GetMapping("/foods/{foodId}")
    public String detail(Model model, @PathVariable(value = "foodId") int foodId) {
        model.addAttribute("food", this.foodService.getFoodById(foodId));
        
        return "food-detail";
    }
}
