/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntn.service.impl;

import com.ntn.pojos.User;
import com.ntn.repository.UserRepository;
import com.ntn.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean addUser(User user) {
        String pass = user.getUserPassword();
        user.setUserPassword(this.passwordEncoder.encode(pass));
        user.setUserRole(User.USER);
        
        return this.userRepository.addUser(user);
    }

    public List<User> getUsers(String userName) {
        return this.userRepository.getUsers(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<User> users = this.getUsers(userName);
        if (users.isEmpty())
            throw new UsernameNotFoundException("Nguoi dung khong ton tai!!!");
        
        User user = users.get(0);
        
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getUserRole()));
        
        return new org.springframework.security.core
                .userdetails.User(user.getUserName(), user.getUserPassword(), auth);        
    }

    @Override
    public User getUserById(int id) {
        return this.userRepository.getUserById(id);
    }
    
}
