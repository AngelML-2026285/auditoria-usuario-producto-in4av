/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.josemejia.system.repository;

/**
 *
 * @author mejia
 */
import org.josemejia.system.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.josemejia.system.config.ConexionDB;

public class AuthenticationRepository implements AuthenticationInterface {

    private ConexionDB conexionDB = ConexionDB.getInstanciaConexionDB();

    @Override
    public User login(String identifier, String password) {
        User user = null;

        try {
            PreparedStatement statement = conexionDB.getConnection()
                    .prepareStatement("select * from Users where (email = ? or user = ?) and password = ?");
            statement.setString(1, identifier);
            statement.setString(2, identifier);
            statement.setString(3, password);

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
            System.out.println("Error al iniciar sesion repository");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return user;
    }
}
