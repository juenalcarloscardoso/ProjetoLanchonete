/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.HashSet;
import java.util.Set;
import modelo.Produto;

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
   public Produto  buscarPorcodigo(int codigo){
       Produto auxiliar = new Produto(codigo);
       if(produtos.contains(auxiliar)){
           for(Produto produto: produtos){
               if(produto.getCodigo()== codigo);
               return produto;
           }
       }
       return null;
   }
   
    @Override
   public boolean deletar(Produto produto){
       return produtos.remove(produto);
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
   
}
