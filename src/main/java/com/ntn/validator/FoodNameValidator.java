/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntn.validator;

import com.ntn.pojos.Food;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author ACER
 */
@Component
public class FoodNameValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Food.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Food f = (Food) target;
        if (!f.getName().contains("NTN"))
            errors.rejectValue("name", "food.name.myErr");
    }
    
}
