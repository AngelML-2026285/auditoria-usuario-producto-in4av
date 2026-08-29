/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.josemejia.system.controller;

/**
 *
 * @author mejia
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.josemejia.system.model.User;
import org.josemejia.system.utils.UserSession;
import org.josemejia.system.utils.ViewFactory;

public class DashboardController implements Initializable {

    @FXML
    private Label lblBienvenida;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User user = UserSession.getInstanciaUserSession().getUser();
        if (user != null) {
            lblBienvenida.setText("Bienvenido, " + user.getName());
        }
    }

    @FXML
    private void onLogout() {
        UserSession.getInstanciaUserSession().setUser(null);
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewLogin();
    }
}
