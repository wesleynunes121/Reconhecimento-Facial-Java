/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.codes;

import model.Sessao;
import model.Usuario;

/**
 *
 * @author jeand
 */
public class TestSerializable {
    public static void main(String[] args) {
        Sessao s = Sessao.PEGAR_SESSAO;
        Integer id = s.getLista_usuarios().getUsuarios().size();
        System.out.println(id);
        //salvar usuário
//        Usuario user = Usuario.create(id, "Jean Master");
//        s.getLista_usuarios().getUsuarios().add(user);
//        s.salvar_dados_usuarios();
        //ler os usuários salvos
        for(Usuario u : s.getLista_usuarios().getUsuarios()){
            System.out.println(u);
        }
    }
}
