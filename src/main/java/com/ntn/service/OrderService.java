/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ntn.service;

import com.ntn.pojos.Cart;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface OrderService {
    boolean addReceipt(Map<Integer, Cart> cart);
}
