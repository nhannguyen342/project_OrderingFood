/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntn.repository.impl;

import com.ntn.pojos.Restaurant;
import com.ntn.repository.RestaurantRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ACER
 */
@Repository
@Transactional
public class RestaurantRespositoryImpl implements RestaurantRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Restaurant> getRestaurants() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Restaurant");
        
        return q.getResultList();
    }

    @Override
    public Restaurant getRestaurantById(int restId) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Restaurant.class, restId);
    }
    
}
