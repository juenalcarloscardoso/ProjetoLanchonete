/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controle;

import java.util.HashSet;
import java.util.Set;
import com.ifpb.modelo.Produto;

/**
 *
 * @author Juvenal Carlos Cardo
 */
public class ProdutoDaoCollection implements ProdutoDao{
    private Set<Produto> produtos;
    
    public ProdutoDaoCollection(){
        produtos = new HashSet<>();
    }
    
    @Override
   public boolean salvar(Produto produto){
        return  produtos.add(produto);
    }
   
    @Override
   public boolean  buscarPorcodigo(int codigo){
       Produto auxiliar = new Produto(codigo);
       if(produtos.contains(auxiliar)){
           for(Produto produto: produtos){
               if(produto.getCodigo()== codigo);
               return true;
           }
       }
       return false;
   }
   
    @Override
   public boolean deletar(int codigo){
       for(Produto p: produtos){
           if(p.getCodigo()== codigo){
               produtos.remove(p);
               return true;
           }
           
       }
       return false;
   }
   
    @Override
   public boolean atualizar(Produto produto){
       Produto auxiliar = new Produto(produto.getCodigo());
       if(produtos.contains(auxiliar)){
           return produtos.remove(auxiliar) && produtos.add(produto);
       }else{
           return false;
       }
   }
   
   public Set<Produto> getProdutos(){
       return produtos;
   }
   
}
