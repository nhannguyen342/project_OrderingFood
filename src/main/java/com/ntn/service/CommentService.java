/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ntn.service;

import com.ntn.pojos.Comment;

/**
 *
 * @author ACER
 */
public interface CommentService {
    Comment addComment(String content, int foodId);
    
}
