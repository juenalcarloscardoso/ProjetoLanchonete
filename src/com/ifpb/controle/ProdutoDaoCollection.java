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
 * Classe onde deve ser implementados todos os métodos de produtos
 * @author Juvenal Carlos Cardoso
 */
public class ProdutoDaoCollection implements ProdutoDao{
    private Set<Produto> produtos;
    private File arquivo;
   
    /**
     *  Contrutor do arquivo e de produtos. 
     * @throws IOException /
     */
     public ProdutoDaoCollection() throws IOException{
        arquivo = new File("Produtos");
        produtos = new HashSet<>();
        if(!arquivo.exists()){
            arquivo.createNewFile();
        }
    }
    /**
     * Método utilizado para listar todos os produtos cadastrados.
     * @return lista de produtos
     */
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
     /**
     * Método para salvar produto.
     * @param produto reprsenta o produto da Lanchonete
     * @return true ou false; 
     */
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

    /**
     * Método para atualizar arquivo onde estar armazenado todos os produtos
     * @param produtos representa um conjunto de produtos da empresa
     
     */
     private void atualizarArquivo(Set<Produto> produtos) throws FileNotFoundException, IOException {
        try(ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream(arquivo))){
            out.writeObject(produtos);
        }
    }
     /**
     * Método para deletar produto pelo codigo.
     * @param codigo representa o codigo do produto a ser deletado
     * @return true ou false;
     */
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
     /**
     * Método para fazer busca de produto pelo codigo.
     * @param codigo representa o codigo do produto
     * @return true po false;
     */
    @Override
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
     /**
     * Método para atualizar produto pelo codigo
     * @param produto representa o produto da Lanchonete
     * @param codigo representa o codigo do produto
     * @return true ou false;
     */
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
   
  
  
    


       
   

