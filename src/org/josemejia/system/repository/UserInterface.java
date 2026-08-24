package org.josemejia.system.repository;

import org.josemejia.system.model.User;

public interface UserInterface {
    void create(User user);
    User buscarPorUsuarioYPassword(String usuario, String password);
}
