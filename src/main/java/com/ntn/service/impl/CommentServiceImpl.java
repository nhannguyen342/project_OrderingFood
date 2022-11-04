/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntn.service.impl;

import com.ntn.pojos.Comment;
import com.ntn.pojos.Food;
import com.ntn.pojos.User;
import com.ntn.repository.CommentRepository;
import com.ntn.repository.FoodRepository;
import com.ntn.repository.UserRepository;
import com.ntn.service.CommentService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;
    
    @Override
    public Comment addComment(String content, int foodId) {
        Food f = this.foodRepository.getFoodById(foodId);
        User u = this.userRepository.getUserById(6);
        
        Comment c = new Comment();
        c.setContent(content);
        c.setFood(f);
        c.setUserId(u);
        c.setCreatedDate(new Date());
        
        return this.commentRepository.addComment(c);
    }
    
    
}
