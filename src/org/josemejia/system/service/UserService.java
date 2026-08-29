/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.josemejia.system.service;

import org.josemejia.system.model.User;
import org.josemejia.system.repository.UserRepository;

/**
 *
 * @author informatica
 */
public class UserService {
    private UserRepository userRepo = new UserRepository();
    
    public UserStatus createUser(String user, String name, String lastName, String email, String passowrd){
        try {
            User newUser = new User(name, lastName, email, password, user);
            userRepo.create(newUser);
            return UserStatus.USER_CREATED;
        } catch (Exception e) {
        }
    
    }
    
}
