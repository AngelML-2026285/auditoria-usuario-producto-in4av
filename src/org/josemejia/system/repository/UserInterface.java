/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package org.josemejia.system.repository;

import org.josemejia.system.model.User;
import java.sql.SQLException;

/**
 *
 * @author informatica
 */
public interface UserInterface {
    void create(User user) throws SQLException;
    User findByEmail(String email);
    User findByEmailOrUsername(String identifier);
}