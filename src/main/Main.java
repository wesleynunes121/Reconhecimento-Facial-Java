/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import br.jeanderson.control.ControlWindow;
import controllers.HomeController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author jeand
 */
public class Main extends Application {
    
    private ControlWindow<HomeController> telaHome;
    
    public static void main(String[] args) {
        //com isso ele executa a função start
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.telaHome = new ControlWindow<>(HomeController.class);
        telaHome.show();
    }
}
