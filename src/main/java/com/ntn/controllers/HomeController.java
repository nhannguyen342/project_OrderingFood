/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntn.controllers;

import com.ntn.pojos.Cart;
import com.ntn.pojos.Restaurant;
import com.ntn.service.FoodService;
import com.ntn.service.RestaurantService;
import com.ntn.utils.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ACER
 */
@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private FoodService foodService;
    
    @ModelAttribute
    public void commonAttrs(Model model, HttpSession session) {
        model.addAttribute("restaurants", this.restaurantService.getRestaurants());
        model.addAttribute("cartCounter", Utils.countCart((Map<Integer, Cart>) session.getAttribute("cart")));
    }
            
    @GetMapping("/")
    public String index(Model model,
            @RequestParam(required = false) Map<String, String> params) {
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        
        String restId = params.get("RestId");
        if (restId == null) {
            model.addAttribute("foods", this.foodService.getFoods(kw, page));

        } else {
            Restaurant r = this.restaurantService.getRestaurantById(Integer.parseInt(restId));
            model.addAttribute("foods", r.getFoodCollection());
        }
        
        model.addAttribute("foodCounter", this.foodService.countFood());

//        model.addAttribute("restaurants", this.restaurantService.getRestaurants());
//        model.addAttribute("foods", this.foodService.getFoods(kw, page));
        
        return "index";
    }
}
