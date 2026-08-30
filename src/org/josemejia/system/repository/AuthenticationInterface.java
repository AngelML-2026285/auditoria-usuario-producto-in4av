/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.josemejia.system.repository;

/**
 *
 * @author mejia
 */
import org.josemejia.system.model.User;

public interface AuthenticationInterface {
    User login(String identifier, String password);
}

