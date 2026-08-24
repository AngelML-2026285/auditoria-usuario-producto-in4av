package org.josemejia.system.repository;

import java.util.List;
import org.josemejia.system.model.Auditoria;

public interface AuditoriaInterface {
    void registrar(Auditoria auditoria);
    List<Auditoria> listar();
}
