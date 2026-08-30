
package org.josemejia.system.utils;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import org.josemejia.system.MainClass;

public class ViewFactory {

    private final String PATH_VIEWS = "/org/josemejia/system/view/";

    public Scene loadFileFXML(String nameFile, int width, int height) {

        String pathOfFile = PATH_VIEWS + nameFile;
        try {
            //llamar al FXMLLoader
            FXMLLoader loadFXML = new FXMLLoader();
            //Obtener la URL del archivo, viene de la clase main

            URL urlFile = MainClass.class.getResource(pathOfFile);
            loadFXML.setBuilderFactory(new JavaFXBuilderFactory());
            loadFXML.setLocation(urlFile);

            return new Scene(loadFXML.load(), width, height);

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }

    public void loadScene(String nameFile) {
        Scene scene = null;

        try {
            switch (nameFile) {
                case "login" -> {
                    SceneManager.getInstanciaSceneManager()
                            .getStagePrincipal()
                            .setTitle("INICIO DE SESION");

                    SceneManager.getInstanciaSceneManager()
                            .getStagePrincipal()
                            .setResizable(false);

                    scene = loadFileFXML("LoginView.fxml", 400, 500);
                }

                case "register" -> {
                    SceneManager.getInstanciaSceneManager()
                            .getStagePrincipal()
                            .setTitle("REGISTRO DE USUARIO");

                    SceneManager.getInstanciaSceneManager()
                            .getStagePrincipal()
                            .setResizable(false);

                    scene = loadFileFXML("CreateAccountView.fxml", 526, 520);
                }

                case "dashboard" -> {
                    SceneManager.getInstanciaSceneManager()
                            .getStagePrincipal()
                            .setTitle("DASHBOARD");

                    SceneManager.getInstanciaSceneManager()
                            .getStagePrincipal()
                            .setResizable(true);

                    scene = loadFileFXML("DashboardView.fxml", 700, 500);
                }

                default ->
                    throw new IllegalArgumentException(
                            "Vista no reconocida: " + nameFile
                    );
            }

            SceneManager.getInstanciaSceneManager().changeScene(scene);

        } catch (RuntimeException e) {
            System.err.println(
                    "Error al cargar la vista '" + nameFile + "': "
                    + e.getMessage()
            );
            e.printStackTrace();
        }
    }

    public void viewRegister() {
        loadScene("register");

    }

    public void viewLogin() {
        loadScene("login");

    }

    public void viewDashboard() {
        loadScene("dashboard");
    }
}
