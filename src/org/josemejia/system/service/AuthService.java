package org.josemejia.system.service;

import org.josemejia.system.model.Auditoria;
import org.josemejia.system.model.User;
import org.josemejia.system.repository.AuditoriaRepository;
import org.josemejia.system.repository.UserRepository;

public class AuthService {

    private final UserRepository userRepository = new UserRepository();
    private final AuditoriaRepository auditoriaRepository = new AuditoriaRepository();

    public User login(String usuario, String password) {
        User user = userRepository.buscarPorUsuarioYPassword(usuario, password);

        if (user != null) {
            auditoriaRepository.registrar(new Auditoria(usuario, "iniciar_sesion", "usuario", "Inicio de sesión exitoso"));
        }

        return user;
    }

    public void registrar(User user) {
        userRepository.create(user);
    }

    public void cerrarSesion(String usuario) {
        auditoriaRepository.registrar(new Auditoria(usuario, "cerrar_sesion", "usuario", "Cierre de sesión"));
    }
}
