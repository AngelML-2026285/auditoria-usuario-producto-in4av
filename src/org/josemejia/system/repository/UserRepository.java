/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.josemejia.system.repository;

import org.josemejia.system.model.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import org.josemejia.system.config.ConexionDB;

/**
 *
 * @author informatica
 */
public class UserRepository implements UserInterface {

    private static final String SP_CREAR = "{call sp_usuario_crear(?, ?, ?, ?, ?, ?)}";

    private static final String SP_LOGIN = "{call sp_usuario_login(?, ?)}";

    @Override
    public void create(User user) {
        try (Connection conexion = ConexionDB.getInstanciaConexionDB().getConnection(); CallableStatement sentencia = conexion.prepareCall(SP_CREAR)) {

            sentencia.setString(1, user.getName());
            sentencia.setString(2, user.getLastname());
            sentencia.setString(3, user.getEmail());
            sentencia.setString(4, user.getUser());
            sentencia.setString(5, user.getPassword());
            sentencia.setString(6, "usuario");

            sentencia.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalStateException("No se pudo registrar el usuario.", e);
        }
    }
    
    

}
