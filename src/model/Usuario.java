/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author jeand
 */
@Data
//cria uma função chamada create que preenche os dados.
@AllArgsConstructor(staticName = "create")
public class Usuario {
    private Integer id;
    private String nome;

    public Usuario() {
    }    
    
}
