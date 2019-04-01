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
 * @author Juvenal Carlos Cardoso
 */
public class FuncionarioDaoCollection implements  FuncionarioDao {
    /**
     * Declaraçãp do arquivo
     */
    private File arquivo;
    /**
     * Declaração de um conjunto de funcionarios.
     */
    private Set<Funcionario> funcionarios;
    
    
    /**
     * Construtor do arquivo e de funcionario.
     */
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
   
    /**
     * Método para editatr funcionario.
     * @param funcionario
     * @return true ou false;
     */
    @Override
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
    /**
     * Método utilizado para verificar se usúario ou senha estão corretos. 
     * @param usuario
     * @param senha
     * @return true ou false;
     */
    @Override
    public boolean autentificar(String usuario, String senha){
       
       Set<Funcionario> funcionarios = getFuncionario();
        for(Funcionario f:funcionarios){
          if( (f.getUsuario().equals(usuario)) && (f.getSenha().equals(senha) )){
              return true;
          }
       }
       return false;
      
    }
    
    /**
     * Método para deletar funcionario.
     * @param funcionario
     * @return true ou false;
     */
   public boolean deletar(Funcionario funcionario){
        return funcionarios.remove(funcionarios);
   }
  
   /**
    *  Método para lista funcionario
    * @return HashSet<>();
    */
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
    /**
     * Método para atualizar o arquivo onde estão armazenado os funcionarios.
     * @param funcionarios
     
     */
    private void atualizarArquivo(Set<Funcionario> funcionarios) throws FileNotFoundException, IOException {
        try(ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream(arquivo))){
            out.writeObject(funcionarios);
        }
    }
    
}
       
   
    
   
    
    
    
    

