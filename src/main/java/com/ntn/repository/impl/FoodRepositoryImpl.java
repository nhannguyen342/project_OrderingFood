/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntn.repository.impl;

import com.ntn.pojos.Food;
import com.ntn.repository.FoodRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class FoodRepositoryImpl implements FoodRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Food> getFoods(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Food> query = builder.createQuery(Food.class);
        Root root = query.from(Food.class);
        query = query.select(root);
        if ( kw != null) {
            Predicate p = builder.like(root.get("name").as(String.class),
                   String.format("%%%s%%", kw));
            query = query.where(p);
        }
        
        query = query.orderBy(builder.desc(root.get("id")));
        
        Query q =session.createQuery(query);
        
        int max = 9;
        q.setMaxResults(max);
        q.setFirstResult((page - 1) * max);
        
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdate(Food food) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(food);
            
            return true;
        } catch (Exception ex) {
            System.err.println("== ADD FOOD ERRFO ==" + ex.getMessage());
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    public long countProduct() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
       
        Query  q = session.createQuery("Select Count(*) From Food");
        
        return  Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public Food getFoodById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Food.class, id);
    }
    
}
