package org.josemejia.system.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.josemejia.system.service.AuthenticationService;
import org.josemejia.system.service.AuthenticationStatus;
import org.josemejia.system.utils.UserSession;
import org.josemejia.system.utils.ViewFactory;


public class LoginController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb){

    }

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

    private AuthenticationService authService = new AuthenticationService();

    @FXML
    private void handleLogin() {
        String email = txtUsuario.getText().trim();
        String password = txtPassword.getText().trim();

        if (email.isBlank() || password.isBlank()) {
            lblError.setText("Usuario y contraseña son obligatorios.");
            return;
        }

        AuthenticationStatus status = authService.login(email, password);

        switch (status) {
            case NOT_EXIST_USER ->
                lblError.setText("No existe una cuenta con ese usuario o correo. Debes registrarte.");

            case INVALID_PASSWORD ->
                lblError.setText("Contraseña incorrecta.");

            case LOGIN_SUCCESS -> {
                lblError.setText("");
                UserSession.getInstanciaUserSession().setUser(authService.getAuthenticatedUser());
                new ViewFactory().viewDashboard();
            }
        }
    }

    @FXML
    private void onRegister() {
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewRegister();
    }
}
