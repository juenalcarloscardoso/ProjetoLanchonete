/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controle;

import com.ifpb.modelo.Funcionario;
import java.util.Set;

/**
 *
 * @author Juvenal Carlos Cardoso
 */
public interface FuncionarioDao {
    /**
     * Método abstrato para salvar funcionarios.
     * @param funcionario
     * @return true ou fase;
     */
    boolean salvarFunc(Funcionario funcionario);
    /**
     * Método abstrato  para etidar funcionario.
     * @param funcionario
     * @return true ou fase;
     */
    boolean edititarFunc(Funcionario funcionario);
    /**
     * Método abstrato para autentificar usúario.
     * @param usuario
     * @param senha
     * @return true po false;
     */
    boolean autentificar(String usuario, String senha);
    Set<Funcionario> getFuncionario();
    
   
    
}
