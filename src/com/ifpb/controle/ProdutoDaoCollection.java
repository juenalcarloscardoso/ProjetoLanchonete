/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controle;

import java.util.HashSet;
import java.util.Set;
import com.ifpb.modelo.Produto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juvenal Carlos Cardo
 */
public class ProdutoDaoCollection implements ProdutoDao{
    private Set<Produto> produtos;
    private File arquivo;
    
     public ProdutoDaoCollection() throws IOException{
        arquivo = new File("Produtos");
        produtos = new HashSet<>();
        if(!arquivo.exists()){
            arquivo.createNewFile();
        }
    }
    
    @Override
     public Set<Produto> getProdutos(){
         if(arquivo.length()>0){
           try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))){
               //Trey com recurso
                return (HashSet) in.readObject();
           } catch (FileNotFoundException ex) {
                 Logger.getLogger(ProdutoDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IOException ex) {
                 Logger.getLogger(ProdutoDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(ProdutoDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
             }
          
        }
            return new HashSet<>();
        
     }
     
    @Override
     public boolean salvar(Produto produto){
         Set<Produto> produtos = getProdutos();
         if(produtos.add(produto)){
             try {
                 atualizarArquivo(produtos);
             } catch (IOException ex) {
                 Logger.getLogger(ProdutoDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
             }
             return true;
         }else{
             return false;
         }
     }

    
     private void atualizarArquivo(Set<Produto> produtos) throws FileNotFoundException, IOException {
        try(ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream(arquivo))){
            out.writeObject(produtos);
        }
    }
     
    @Override
     public boolean deletar(int codigo){
         Set<Produto> produtos = getProdutos();
          for(Produto p: produtos){
              if(p.getCodigo()==codigo){
                 produtos.remove(p);
                  try {
                      atualizarArquivo(produtos);
                  } catch (IOException ex) {
                      Logger.getLogger(ProdutoDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
                  }
                return true;
              }
              
          }
          return false;
             
 }
     
     public boolean buscarPorcodigo(int codigo){
         Set<Produto> produtos = getProdutos();
         for(Produto p: produtos){
             //obs codigo
             if(p.getCodigo()== codigo){
                 return true;
                 
             }
         }
         return false;
       
     }
     
    @Override
      public boolean atualizar(Produto produto, int codigo){
          Set<Produto> produtos = getProdutos();
          for(Produto p: produtos){
              if(p.getCodigo()== codigo){
                produtos.remove(p);
                produtos.add(produto);
                  try {
                      atualizarArquivo(produtos);
                  } catch (IOException ex) {
                      Logger.getLogger(ProdutoDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
                  }
                return true;
              }
          }
          return false;
      }

    

    

    
      
    
    
       
   }
   
  
  
    


       
   

