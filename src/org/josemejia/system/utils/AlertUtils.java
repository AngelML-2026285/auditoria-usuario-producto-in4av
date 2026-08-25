/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.josemejia.system.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 *
 * @author informatica
 */
public class AlertUtils {
    
    public enum TipoNotificacion {
        INFO("/org/josemejia/system/resources/image/rem_normal.png", Alert.AlertType.INFORMATION),
        EXITO("/org/josemejia/system/resources/image/rem_feliz.png", Alert.AlertType.INFORMATION),
        ERROR("/org/josemejia/system/resources/image/rem_asustada.png", Alert.AlertType.ERROR),
        ADVERTENCIA("/org/josemejia/system/resources/image/rem_duda.png", Alert.AlertType.WARNING);

        private final String rutaImagen;
        private final Alert.AlertType tipoAlerta;

        TipoNotificacion(String rutaImagen, Alert.AlertType tipoAlerta) {
            this.rutaImagen = rutaImagen;
            this.tipoAlerta = tipoAlerta;
        }

        public String getRutaImagen() {
            return rutaImagen;
        }

        public Alert.AlertType getTipoAlerta() {
            return tipoAlerta;
        }
    }

    private AlertUtils() {
    }

    public static void mostrarAlertaPersonalizada(String titulo, String mensaje) {
        mostrarAlertaPersonalizada(titulo, mensaje, TipoNotificacion.INFO);
    }

    public static void mostrarAlertaPersonalizada(String titulo, String mensaje, TipoNotificacion tipo) {
        Alert alerta = new Alert(tipo.getTipoAlerta());
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        Label etiquetaMensaje = new Label(mensaje);
        etiquetaMensaje.setWrapText(true);
        etiquetaMensaje.setMaxWidth(300);
        Image imagenRem = new Image(AlertUtils.class.getResourceAsStream(tipo.getRutaImagen()));
        ImageView vistaRem = new ImageView(imagenRem);
        vistaRem.setFitWidth(150);
        vistaRem.setPreserveRatio(true);
        HBox contenedorLayout = new HBox(15);
        contenedorLayout.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER);
        HBox.setHgrow(etiquetaMensaje, javafx.scene.layout.Priority.ALWAYS);
        contenedorLayout.getChildren().addAll(etiquetaMensaje, vistaRem);
        alerta.getDialogPane().setContent(contenedorLayout);
        alerta.showAndWait();
    }
    
    
    
}
