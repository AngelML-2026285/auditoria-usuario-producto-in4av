package org.josemejia.system.repository;

import java.util.List;
import org.josemejia.system.model.Compra;
import org.josemejia.system.model.DetalleCompra;

public interface CompraInterface {
    void crear(Compra compra, List<DetalleCompra> detalles);
}
