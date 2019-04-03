/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controle;

import com.ifpb.modelo.Funcionario;
import java.util.Set;

/**
 * Classe que representa todos os métodos abstratos que tem que ser implementado na classe FuncionarioDaoCollection
 * @author Juvenal Carlos Cardoso
 */
public interface FuncionarioDao {
   
    boolean salvarFunc(Funcionario funcionario);
    boolean edititarFunc(Funcionario funcionario);
    boolean autentificar(String usuario, String senha);
    Set<Funcionario> getFuncionario();
    
   
    
}
