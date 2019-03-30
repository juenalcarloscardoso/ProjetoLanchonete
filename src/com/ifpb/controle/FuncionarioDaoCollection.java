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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juvenal Carlos Cardo
 */
public class FuncionarioDaoCollection implements  FuncionarioDao {
    private File arquivo;
    
    private Set<Funcionario> funcionarios;
    
    
    
    public FuncionarioDaoCollection() throws IOException{
        funcionarios = new HashSet<>();
        arquivo = new File("funcionarios");
        if(!arquivo.exists())try{
            arquivo.createNewFile();
        }catch (IOException ex) {
            Logger.getLogger(FuncionarioDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    
    
   //================================================================================// 
    @Override
    
    public boolean salvarFunc(Funcionario funcionario){
        Set<Funcionario> funcionarios = getFuncionario();
        if(funcionarios.add(funcionario)){
            try {
                atualizarArquivo(funcionarios);
            } catch (IOException ex) {
                Logger.getLogger(FuncionarioDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }else{
            return false;
        }
       
    }
    //======================================================================================//
    
    //======================================================================================//
    public boolean edititarFunc(Funcionario funcionario){
        /*Funcionario auxiliar = new Funcionario(funcionario.getCpf());
        if(funcionarios.contains(auxiliar)){
            return funcionarios.remove(auxiliar) && funcionarios.add(funcionario);
        }else{
            return false;
        }
        */
        
        Set<Funcionario> funcionarios = getFuncionario();
            for(Funcionario f: funcionarios){
                if(f.getCpf().equals(f.getCpf())){
                funcionarios.remove(f);
                funcionarios.add(funcionario);
                    try {
                        atualizarArquivo(funcionarios);
                    } catch (IOException ex) {
                        Logger.getLogger(FuncionarioDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
                    }
                return true;
                }
                
                }
                
            
          return false;
        
     }
    
    //==================================================================================================
    
    @Override
    public boolean autentificar(String usuario, String senha){
       //return funcionarios.stream().anyMatch((f) -> (f.getUsuario().equals(usuario) && f.getSenha().equals(senha)));
       
        Set<Funcionario> funcionarios = getFuncionario();
        for(Funcionario f:funcionarios){
          if( (f.getUsuario().equals(usuario)) && (f.getSenha().equals(senha) )){
              return true;
          }
       }
       return false;
      
    }
    
    //falta 
   public boolean deletar(Funcionario funcionario){
        return funcionarios.remove(funcionarios);
   }
   //Metodo para lista funcionario
   public Set<Funcionario> getFuncionario(){
       
        if(arquivo.length()>0){
           //ler do arquivo
           //in so exite dentro do try 
           try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))){
               //Trey com recurso
                return (HashSet) in.readObject();
           } catch (FileNotFoundException ex) {
                Logger.getLogger(FuncionarioDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FuncionarioDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FuncionarioDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
            return new HashSet<>();
        }

    private void atualizarArquivo(Set<Funcionario> funcionarios) throws FileNotFoundException, IOException {
        try(ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream(arquivo))){
            out.writeObject(funcionarios);
        }
    }
    
}
       
   
    
   
    
    
    
    

