/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.jeanderson.annotations.DefineConfiguration;
import br.jeanderson.control.ControlWindow;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author jeand
 */
@DefineConfiguration(url_fxml = "/view/Home.fxml", title = "Sistema de Reconhecimento Facial")
public class HomeController implements Initializable {

    @FXML
    private ScrollPane scrollBase;
    private ControlWindow<CadastroController> telaCadastro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.telaCadastro = new ControlWindow<>(CadastroController.class);
    }    

    @FXML
    private void actionCadastrar(MouseEvent event) {
        this.setNode(this.telaCadastro.getRoot());
    }

    @FXML
    private void ActionTreinar(MouseEvent event) {
    }

    @FXML
    private void actionReconhecer(MouseEvent event) {
    }
    
    /**
     * Troca a telas conforme clica e com uma transição.
     * @param node 
     */
    public void setNode(Node node) {       
        this.scrollBase.setContent(node);
        FadeTransition ft = new FadeTransition(Duration.millis(1000));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }
    
}