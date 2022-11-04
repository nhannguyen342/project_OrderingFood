/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntn.formatter;

import com.ntn.pojos.Restaurant;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ACER
 */
public class RestaurantFormatter implements Formatter<Restaurant>{

    @Override
    public String print(Restaurant object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public Restaurant parse(String restId, Locale locale) throws ParseException {
        Restaurant r = new Restaurant();
        r.setId(Integer.parseInt(restId));
        
        return r;
    }
    
}
