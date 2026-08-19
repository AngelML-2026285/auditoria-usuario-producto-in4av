/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package org.josemejia.system;
import javafx.application.Application;
import javafx.stage.Stage;
import org.josemejia.system.utils.SceneManager;
import org.josemejia.system.utils.ViewFactory;

/**
 *
 * @author informatica
 */
public class MainClass extends Application{

    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
    @Override
    public void start(Stage stageRoot){
        SceneManager.getInstanciaSceneManager().setStagePrincipal(stageRoot);
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewLogin();
    
    }
    
}
