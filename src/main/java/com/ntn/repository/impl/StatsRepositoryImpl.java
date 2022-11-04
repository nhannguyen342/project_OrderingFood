/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntn.repository.impl;

import com.ntn.pojos.Restaurant;
import com.ntn.pojos.Food;
import com.ntn.repository.StatsRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class StatsRepositoryImpl implements StatsRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Object[]> resStats() {
       Session session = this.sessionFactory.getObject().getCurrentSession();
    
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootF = q.from(Food.class);
        Root rootR = q.from(Restaurant.class);
        
        q.where(b.equal(rootF.get("restaurant"), rootR.get("id")));
        
        q.multiselect(rootR.get("id"), rootR.get("name"),
                b.count(rootF.get("id")));
        q.groupBy(rootR.get("id"));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }
    
}
