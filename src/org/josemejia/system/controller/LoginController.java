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
import javafx.scene.input.MouseEvent;
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
    
    @FXML
    private void onRegister() {
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewRegister();
    }
}
