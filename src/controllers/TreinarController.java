/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import br.jeanderson.annotations.DefineConfiguration;
import br.jeanderson.enums.DialogType;
import br.jeanderson.util.DialogFX;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import reconhecimento.Treinamento;

@DefineConfiguration(url_fxml = "/view/Treinar.fxml")
public class TreinarController implements Initializable {

    @FXML
    private AnchorPane apBase;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void actionTreinar(MouseEvent event) {
        Treinamento treinamento = new Treinamento();
        Thread t = new Thread(() -> {
            try {
                treinamento.treinar();
                Platform.runLater(() -> {
                    DialogFX.showMessage("Classificadores foram treinados com sucesso.", "Treinados", DialogType.SUCESS);
                });
            } catch (Exception ex) {
                Platform.runLater(() -> {
                    DialogFX.showMessage("Erro", "Houve um erro: " + ex.getMessage(), DialogType.ERRO);
                });
            }
        });
        t.setDaemon(true);
        t.start();

    }

}
