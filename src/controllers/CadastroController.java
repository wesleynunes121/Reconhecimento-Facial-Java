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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.bytedeco.javacv.FrameGrabber;
import reconhecimento.Captura;
import reconhecimento.Sessao;
import reconhecimento.Usuario;

/**
 * FXML Controller class
 *
 * @author jeand
 */
@DefineConfiguration(url_fxml = "/view/Cadastrar.fxml")
public class CadastroController implements Initializable {

    @FXML
    private TextField txtNome;
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
    private void actionCapturar(MouseEvent event) {
        if(!this.txtNome.getText().trim().isEmpty()){
            String nome = this.txtNome.getText();
            Sessao s = Sessao.PEGAR_SESSAO;
            Integer id = s.getLista_usuarios().getUsuarios().size();
            Usuario user = Usuario.create(id, nome);
            s.getLista_usuarios().getUsuarios().add(user);
            s.salvar_dados_usuarios();
            //faz a parada da captura
            Captura c = new Captura();
            try {
                c.capturador(id);
                DialogFX.showMessage("Salvo", "Salvo com sucesso", DialogType.SUCESS);
            } catch (FrameGrabber.Exception | InterruptedException ex) {
                Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, ex);
                DialogFX.showMessage("Erro", "Houve um erro: "+ex.getMessage(), DialogType.ERRO);
            }
        }else{
            DialogFX.showMessage("Digite seu nome primeiro", "Nome vazio", DialogType.WARNING);
        }
        
    }
    
}
