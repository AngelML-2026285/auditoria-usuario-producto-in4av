package org.josemejia.system.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.josemejia.system.utils.Validations;
import org.josemejia.system.utils.ViewFactory;
import org.josemejia.system.utils.AlertInformation; 

public class CreateAcountController implements Initializable {
    
    @FXML
    private TextField txtName;
    
    @FXML
    private TextField txtLastName;
    
    @FXML
    private TextField txtUserName;
    
    @FXML
    private TextField txtEmail;
    
    @FXML
    private PasswordField pwdPassword;
    
    @FXML
    private PasswordField pwdPasswordConfirm;
    
    @FXML
    private Button btnRegister;
    
    @FXML
    private Button btnCancel;
    
    private Validations validate = new Validations();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    public void onCancelRegister(MouseEvent event) {
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewLogin();
    }
    
    @FXML
    public void onRegisterUser(MouseEvent event) {
        String user = txtUserName.getText().trim();
        String name = txtName.getText().trim();
        String lastName = txtLastName.getText().trim();
        String email = txtEmail.getText().trim();
        String password = pwdPassword.getText().trim();
        String confirmPassword = pwdPasswordConfirm.getText().trim();
        
        if (validate.validateTextFieldEmpty(user) || 
            validate.validateTextFieldEmpty(name) || 
            validate.validateTextFieldEmpty(lastName) || 
            validate.validateTextFieldEmpty(email) || 
            validate.validateTextFieldEmpty(password) || 
            validate.validateTextFieldEmpty(confirmPassword)) {
            
            AlertInformation.viewAlert(
                "Campos incompletos",
                "Advertencia",
                "Por favor, complete todos los campos para poder registrarse.",
                "ADVERTENCIA"
            );
            return;
        }
        
        String msgField = "";
        if(validate.validateTextLength(user,25)== false)
            msgField += "El campo Usuario es mayor a 25 letras \n";
        if(validate.validateTextLength(name,50)== false)
            msgField += "El campo NOMBRE es mayor a 50 letras \n";
        if(validate.validateTextLength(lastName,50)== false)
            msgField += "El campo APELLIDO es mayor a 50 letras \n";
        if(validate.validateTextLength(email,50)== false)
            msgField += "El campo EMAIL es mayor a 50 letras \n";
        if(validate.validateTextLength(password,35)== false)
            msgField += "El campo PASSWORD es mayor a 35 letras \n";
        if(validate.validateTextLength(confirmPassword,35)== false)
            msgField += "El campo CONFIRMAR PASSWORD es mayor a 35 letras \n";
        
        if(msgField.isEmpty() == false){
            AlertInformation.viewAlert(
                "ERROR",
                "ERROR DE CAMPO",
                msgField,
                "ERROR"
            );
            return;
        }
        
        if (!validate.equalsText(password, confirmPassword)) {
            AlertInformation.viewAlert(
                "Error de contraseña",
                "Las contraseñas no coinciden",
                "Verifica las contraseñas.",
                "ERROR"
            );
            return;
        }
        
        if (!validate.validateEmail(email)) {
            AlertInformation.viewAlert(
                "Correo inválido",
                "Formato incorrecto",
                "Por favor, ingrese un correo electrónico válido (ej: usuario@dominio.com).",
                "ERROR"
            );
            return;
        }
        
        AlertInformation.viewAlert(
            "Registro Exitoso",
            "Cuenta creada",
            "El usuario '" + user + "' ha sido registrado correctamente.",
            "EXITO"
        );
        
        limpiarCampos();
    }
    
    private void limpiarCampos() {
        txtUserName.clear();
        txtName.clear();
        txtLastName.clear();
        txtEmail.clear();
        pwdPassword.clear();
        pwdPasswordConfirm.clear();
    }
}