/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controle;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import com.ifpb.modelo.Funcionario;
import com.ifpb.modelo.Produto;

/**
 *
 * @author Juvenal Carlos Cardo
 */
public class FuncionarioDaoCollection implements  FuncionarioDao {
    
    private Set<Funcionario> funcionarios;
    
    public FuncionarioDaoCollection(){
        funcionarios = new HashSet<>();
    }

    
    
    
    @Override
    public boolean salvarFunc(Funcionario funcionario){
        return funcionarios.add(funcionario);
    }
    public boolean edititarFunc(Funcionario funcionario){
        Funcionario auxiliar = new Funcionario(funcionario.getCpf());
        if(funcionarios.contains(auxiliar)){
            return funcionarios.remove(auxiliar) && funcionarios.add(funcionario);
        }else{
            return false;
        }
        
     }
    
    public boolean autentificar(String usuario, String senha){
       return funcionarios.stream().anyMatch((f) -> (f.getUsuario().equals(usuario) && f.getSenha().equals(senha)));
    }
    
   public boolean deletar(Funcionario funcionario){
        return funcionarios.remove(funcionarios);
   }
   
   public Set<Funcionario> getFuncionario(){
       
       
   }
    
    
    
    
    
    
}
