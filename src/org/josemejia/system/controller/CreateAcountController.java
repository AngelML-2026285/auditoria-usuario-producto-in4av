/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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

/**
 *
 * @author informatica
 */
public class CreateAcountController implements Initializable{
    
    @FXML
    private TextField txtName;
    
    @FXML
    private TextField txtLastName;
    
    @FXML
    private TextField txtUserName;
    
    @FXML
    private TextField  txtEmail;
    
    @FXML
    private PasswordField pwdPassword;
    
    @FXML
    private PasswordField PwdConfirmPassword;
    
    @FXML
    private Button btnRegister;
    
    @FXML
    private Button btnCancel;
    
    private Validations validate = new Validations();
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
    
    }
    
    @FXML
    public void onCancelRegister(MouseEvent event){
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewLogin();
    }
    
    @FXML
    public void onRegisterUser(MouseEvent event){
        String email = txtEmail.getText().trim();
        boolean validEmail = validate.validateEmail(email);
        if(validEmail == true)
            System.out.println("si esta valido");
        else
            System.out.println("No esta valido");
    
    }
        
    
    
    
}
