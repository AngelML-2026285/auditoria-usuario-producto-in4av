package org.josemejia.system.repository;

import org.josemejia.system.config.ConexionDB;
import org.josemejia.system.model.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements UserInterface {

    private static final String SP_CREAR = "{call sp_usuario_crear(?, ?, ?, ?, ?, ?)}";

    private static final String SP_LOGIN = "{call sp_usuario_login(?, ?)}";

    @Override
    public void create(User user) {
        try (Connection conexion = ConexionDB.getInstanciaConexionDB().getConnection();
             CallableStatement sentencia = conexion.prepareCall(SP_CREAR)) {

            sentencia.setString(1, user.getName());
            sentencia.setString(2, user.getLastname());
            sentencia.setString(3, user.getEmail());
            sentencia.setString(4, user.getUser());
            sentencia.setString(5, user.getPassword());
            sentencia.setString(6, "cajero");

            sentencia.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalStateException("No se pudo registrar el usuario.", e);
        }
    }

    @Override
    public User buscarPorUsuarioYPassword(String usuario, String password) {
        try (Connection conexion = ConexionDB.getInstanciaConexionDB().getConnection();
             CallableStatement sentencia = conexion.prepareCall(SP_LOGIN)) {

            sentencia.setString(1, usuario);
            sentencia.setString(2, password);

            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    User user = new User();
                    user.setIdUser(resultado.getString("id_user"));
                    user.setName(resultado.getString("name"));
                    user.setLastname(resultado.getString("lastname"));
                    user.setEmail(resultado.getString("email"));
                    user.setUser(resultado.getString("user"));
                    user.setRol(resultado.getString("rol"));
                    return user;
                }
                return null;
            }

        } catch (SQLException e) {
            throw new IllegalStateException("No se pudo validar el usuario.", e);
        }
    }
}
