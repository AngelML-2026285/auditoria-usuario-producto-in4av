package org.josemejia.system.utils;

import org.josemejia.system.model.User;

public class SessionManager {

    private static SessionManager instanciaSessionManager;
    private User usuarioActual;

    private SessionManager() {
    }

    public static SessionManager getInstanciaSessionManager() {
        if (instanciaSessionManager == null) {
            instanciaSessionManager = new SessionManager();
        }
        return instanciaSessionManager;
    }

    public User getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(User usuarioActual) {
        this.usuarioActual = usuarioActual;
    }
}
