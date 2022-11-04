/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntn.repository.impl;

import com.ntn.pojos.Cart;
import com.ntn.pojos.FoodOrder;
import com.ntn.pojos.FoodOrderDetail;
import com.ntn.repository.FoodRepository;
import com.ntn.repository.OrderRepository;
import com.ntn.repository.UserRepository;
import com.ntn.utils.Utils;
import java.util.Date;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author ACER
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private LocalSessionFactoryBean SessionFactory;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addReceipt(Map<Integer, Cart> cart) {
        try {
            Session session = this.SessionFactory.getObject().getCurrentSession();
        
            FoodOrder order = new FoodOrder();
            order.setUserId(this.userRepository.getUserById(6));
            order.setCreatedDate(new Date());
            Map<String, String> stats = Utils.cartStats(cart);
            order.setAmount(Long.parseLong(stats.get("amount")));
//            order.setRestaurantId(restaurantId);
            session.save(order);

            for (Cart c: cart.values()) {
                FoodOrderDetail d = new FoodOrderDetail();
                d.setFoodOrder(order);
                d.setFoodId(this.foodRepository.getFoodById(c.getFoodId()));
                d.setTotalPrice(c.getUnitPrice());
                d.setFoodQuantity(c.getQuantity());

                session.save(d);
            } 
            
            return true;
        }catch (HibernateException ex) {
                    ex.printStackTrace();
                    }
        
        
        return false;
    }
    
}
