/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.josemejia.system.utils;

/**
 *
 * @author mejia
 */

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class AnimacionUtils {

    private AnimacionUtils() {
    }

    public static void aplicarFadeIn(Node nodo) {
        nodo.setOpacity(0);
        FadeTransition fade = new FadeTransition(Duration.millis(400), nodo);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    public static void aplicarEfectoHover(Node nodo) {
        ScaleTransition crecer = new ScaleTransition(Duration.millis(120), nodo);
        crecer.setToX(1.05);
        crecer.setToY(1.05);

        ScaleTransition encoger = new ScaleTransition(Duration.millis(120), nodo);
        encoger.setToX(1.0);
        encoger.setToY(1.0);

        nodo.setOnMouseEntered(evento -> {
            encoger.stop();
            crecer.playFromStart();
        });

        nodo.setOnMouseExited(evento -> {
            crecer.stop();
            encoger.playFromStart();
        });
    }
}