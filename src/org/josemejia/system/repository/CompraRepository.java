package org.josemejia.system.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import org.josemejia.system.config.ConexionDB;
import org.josemejia.system.model.Compra;
import org.josemejia.system.model.DetalleCompra;

public class CompraRepository implements CompraInterface {

    private static final String SP_COMPRA_CREAR = "{call sp_compra_crear(?, ?, ?)}";

    private static final String SP_DETALLE_CREAR = "{call sp_detalle_compra_crear(?, ?, ?, ?)}";

    @Override
    public void crear(Compra compra, List<DetalleCompra> detalles) {
        String idCompra = UUID.randomUUID().toString();

        try (Connection conexion = ConexionDB.getInstanciaConexionDB().getConnection()) {

            try (CallableStatement sentenciaCompra = conexion.prepareCall(SP_COMPRA_CREAR)) {
                sentenciaCompra.setString(1, idCompra);
                sentenciaCompra.setString(2, compra.getUsuario());
                sentenciaCompra.setDouble(3, compra.getTotal());
                sentenciaCompra.executeUpdate();
            }

            try (CallableStatement sentenciaDetalle = conexion.prepareCall(SP_DETALLE_CREAR)) {
                for (DetalleCompra detalle : detalles) {
                    sentenciaDetalle.setString(1, idCompra);
                    sentenciaDetalle.setString(2, detalle.getIdProducto());
                    sentenciaDetalle.setInt(3, detalle.getCantidad());
                    sentenciaDetalle.setDouble(4, detalle.getPrecioUnitario());
                    sentenciaDetalle.executeUpdate();
                }
            }

        } catch (SQLException e) {
            throw new IllegalStateException("No se pudo registrar la compra.", e);
        }
    }
}
