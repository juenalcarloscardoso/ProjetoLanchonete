/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controle;

import com.ifpb.modelo.Produto;
import java.util.Set;

/**
 *
 * @author Juvenal Carlos Cardoso
 */
public interface ProdutoDao {
    /**
     * Método para salvar produto.
     * @param produto
     * @return true ou false;
     */
    boolean salvar(Produto produto);
    /**
     * Método para fazer busca de produto pelo codigo.
     * @param codigo
     * @return true po false;
     */
    boolean buscarPorcodigo(int codigo);
    /**
     * Método para deletar produto pelo codigo.
     * @param codigo
     * @return true ou false;
     */
    boolean deletar(int codigo);
    /**
     * Método para atualizar produto pelo codigo
     * @param produto
     * @param codigo
     * @return true ou false;
     */
    boolean atualizar(Produto produto,int codigo);
    /**
     * Método para lista produtos.
     */
    public Set<Produto> getProdutos();
}
