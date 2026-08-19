package org.josemejia.system.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblError;

    @FXML
    private Button btnLogin;

    @FXML
    private Hyperlink linkRegistro;

    @FXML
    private void handleLogin() {
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();

        if (usuario == null || usuario.isBlank() || password == null || password.isBlank()) {
            lblError.setText("Usuario y contraseña son obligatorios.");
            return;
        }

        // TODO: reemplazar esto por una llamada real a un AuthService
        
        lblError.setText("Autenticación aún no implementada.");
    }
}
