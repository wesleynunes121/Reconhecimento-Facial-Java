/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reconhecimento;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author jeand
 */
public enum Sessao {
    //utilizando o enum, quando ele é chamado ele se mantem enquanto o sistema estiver executando, ou seja o construtor dele só será chamado uma vez! E ele pode ser chamado em qualquer classe.
    PEGAR_SESSAO();
    private ListaUsuarios lista_usuarios;

    private Sessao() {
       this.carregar_usuarios();
    }
    
    private void carregar_usuarios(){
        try {
            File arquivo = new File("user.bin");
            if(arquivo.exists()){
                Input entrada = new Input(new FileInputStream(arquivo));
                Kryo k = new Kryo();
                k.register(ArrayList.class);
                k.register(ListaUsuarios.class);
                k.register(Usuario.class);
                this.lista_usuarios = k.readObject(entrada, ListaUsuarios.class);
                entrada.close();
            }else{
                this.lista_usuarios = new ListaUsuarios();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean salvar_dados_usuarios(){
         try {
            File arquivo = new File("user.bin");
            if (arquivo.exists()) {
                arquivo.delete();
            }
            Kryo kryo = new Kryo();
            kryo.register(ArrayList.class);
            kryo.register(ListaUsuarios.class);
            kryo.register(Usuario.class);
            Output saida = new Output(new FileOutputStream(arquivo));
            kryo.writeObject(saida, this.lista_usuarios);
            saida.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ListaUsuarios getLista_usuarios() {
        return lista_usuarios;
    }
    
    
}
