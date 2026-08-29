/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.josemejia.system.utils;

/**
 *
 * @author mejia
 */
import org.josemejia.system.model.User;

public class UserSession {

    private static UserSession instanciaUserSession;
    private User user;

    private UserSession() {
    }

    public static UserSession getInstanciaUserSession() {
        if (instanciaUserSession == null)
            instanciaUserSession = new UserSession();
        return instanciaUserSession;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
