/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reconhecimento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 *
 * @author jeand
 */
public class ListaUsuarios implements Serializable{
    //cria um metodo GET
    @Getter
    private final List<Usuario> usuarios;

    public ListaUsuarios() {
        this.usuarios = new ArrayList<>();
    }
    
    
}
