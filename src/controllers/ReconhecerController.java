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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.ReconhecimentoEigenFaces;
import model.ReconhecimentoFisherFaces;
import model.ReconhecimentoLBPH;
import model.Sessao;
import model.Usuario;

@DefineConfiguration(url_fxml = "/view/Reconhecer.fxml")
public class ReconhecerController implements Initializable {

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
    private void actionEigenfaces(MouseEvent event) {
        ReconhecimentoEigenFaces r = new ReconhecimentoEigenFaces();
        try{
            r.reconhecer(this.pegar_lista_usuarios());
        }catch(Exception ex){
            ex.printStackTrace();
            DialogFX.showMessage("Erro", "Houve um erro: "+ex.getMessage(), DialogType.ERRO);
        }
    }

    @FXML
    private void actionFisherfaces(MouseEvent event) {
        ReconhecimentoFisherFaces r = new ReconhecimentoFisherFaces();
        try{
            r.reconhecer(this.pegar_lista_usuarios());
        }catch(Exception ex){
            ex.printStackTrace();
            DialogFX.showMessage("Erro", "Houve um erro: "+ex.getMessage(), DialogType.ERRO);
        }
    }

    @FXML
    private void actionLBPH(MouseEvent event) {
        ReconhecimentoLBPH r = new ReconhecimentoLBPH();
        try{
            r.reconhecer(this.pegar_lista_usuarios());
        }catch(Exception ex){
            ex.printStackTrace();
            DialogFX.showMessage("Erro", "Houve um erro: "+ex.getMessage(), DialogType.ERRO);
        }
    }
    
    private String[] pegar_lista_usuarios(){
        Sessao s = Sessao.PEGAR_SESSAO;
        String[] nomes = new String[(s.getLista_usuarios().getUsuarios().size() + 1)];
        for(int i = 0; i < nomes.length; i++){
            if(i == 0){
                nomes[i] = "";
            }else{
                nomes[i] = s.getLista_usuarios().getUsuarios().get((i - 1)).getNome();
            }            
        }
        return nomes;
    }
    
}
