/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.josemejia.system.repository;

import org.josemejia.system.model.User;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.josemejia.system.config.ConexionDB;

/**
 *
 * @author informatica
 */
public class UserRepository implements UserInterface {

    private CallableStatement callSP;
    private ConexionDB conexionDB = ConexionDB.getInstanciaConexionDB();

    @Override
    public void create(User user) throws SQLException {
        try {
            callSP = conexionDB.getConnection()
                    .prepareCall("{call sp_create_users(?,?,?,?,?)}");

            callSP.setString(1, user.getName());
            callSP.setString(2, user.getLastname());
            callSP.setString(3, user.getEmail());
            callSP.setString(4, user.getUser());
            callSP.setString(5, user.getPassword());

            callSP.execute();
            callSP.close();

        } catch (SQLException e) {
            System.out.println("Error al crear usuario repository");
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw e; // re-lanzamos para que UserService.createUser() se entere del fallo
        }
    }

    @Override
    public User findByEmail(String email) {
        User user = null;

        try {
            PreparedStatement statement = conexionDB.getConnection()
                    .prepareStatement("select * from Users where email = ?");
            statement.setString(1, email);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                user = new User();
                user.setIdUser(result.getString("id_user"));
                user.setName(result.getString("name"));
                user.setLastname(result.getString("lastname"));
                user.setEmail(result.getString("email"));
                user.setUser(result.getString("user"));
                user.setPassword(result.getString("password"));
            }

            result.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar usuario repository");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User findByEmailOrUsername(String identifier) {
        User user = null;

        try {
            PreparedStatement statement = conexionDB.getConnection()
                    .prepareStatement("select * from Users where email = ? or user = ?");
            statement.setString(1, identifier);
            statement.setString(2, identifier);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                user = new User();
                user.setIdUser(result.getString("id_user"));
                user.setName(result.getString("name"));
                user.setLastname(result.getString("lastname"));
                user.setEmail(result.getString("email"));
                user.setUser(result.getString("user"));
                user.setPassword(result.getString("password"));
            }

            result.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar usuario por correo o usuario, repository");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return user;
    }
}
