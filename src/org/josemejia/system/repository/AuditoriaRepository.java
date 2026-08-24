package org.josemejia.system.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.josemejia.system.config.ConexionDB;
import org.josemejia.system.model.Auditoria;

public class AuditoriaRepository implements AuditoriaInterface {

    private static final String SP_REGISTRAR = "{call sp_auditoria_registrar(?, ?, ?, ?)}";

    private static final String SP_LISTAR = "{call sp_auditoria_listar()}";

    @Override
    public void registrar(Auditoria auditoria) {
        try (Connection conexion = ConexionDB.getInstanciaConexionDB().getConnection();
             CallableStatement sentencia = conexion.prepareCall(SP_REGISTRAR)) {

            sentencia.setString(1, auditoria.getUsuario());
            sentencia.setString(2, auditoria.getAccion());
            sentencia.setString(3, auditoria.getEntidad());
            sentencia.setString(4, auditoria.getDetalle());

            sentencia.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalStateException("No se pudo registrar la auditoría.", e);
        }
    }

    @Override
    public List<Auditoria> listar() {
        List<Auditoria> registros = new ArrayList<>();

        try (Connection conexion = ConexionDB.getInstanciaConexionDB().getConnection();
             CallableStatement sentencia = conexion.prepareCall(SP_LISTAR);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {
                registros.add(new Auditoria(
                        resultado.getString("id_auditoria"),
                        resultado.getString("usuario"),
                        resultado.getString("accion"),
                        resultado.getString("entidad"),
                        resultado.getString("detalle"),
                        resultado.getString("fecha")
                ));
            }

        } catch (SQLException e) {
            throw new IllegalStateException("No se pudo listar la auditoría.", e);
        }

        return registros;
    }
}
