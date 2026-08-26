/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.josemejia.system.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AlertInformation {
    
    /**
     * Muestra una alerta con la imagen correspondiente al tipo
     */
    public static void viewAlert(String title, String headerText, 
                                 String contentText, String alertType) {
        Alert alert = new Alert(getAlertType(alertType));
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        
        // Setear imagen automáticamente según el tipo
        setImage(alert, alertType);
        
        alert.showAndWait();
    }
    
    /**
     * Retorna el AlertType según el string recibido
     */
    private static AlertType getAlertType(String type) {
        switch (type.toUpperCase()) {
            case "INFORMATION": return AlertType.INFORMATION;
            case "WARNING":     return AlertType.WARNING;
            case "ERROR":       return AlertType.ERROR;
            case "CONFIRMATION":return AlertType.CONFIRMATION;
            default:            return AlertType.INFORMATION;
        }
    }
    
    /**
     * Setea la imagen automáticamente según el tipo de alerta
     */
    private static void setImage(Alert alert, String type) {
        String imageName;
        
        switch (type.toUpperCase()) {
            case "ERROR":        imageName = "rem_asustada.png";        break;
            case "WARNING":      imageName = "rem_duda.png";      break;
            case "INFORMATION":  imageName = "rem_normal.png";         break;
            case "CONFIRMATION": imageName = "rem_feliz.png"; break;
            default:             imageName = "rem_normal.png";         break;
        }
        
        String path = "/org/josemejia/system/resources/image/" + imageName;
        Image image = new Image(AlertInformation.class.getResourceAsStream(path));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(75);
        imageView.setFitHeight(75);
        
        alert.setGraphic(imageView);
    }
    
   
}