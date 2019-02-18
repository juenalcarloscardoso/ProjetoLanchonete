/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controle;

import com.ifpb.modelo.Produto;

/**
 *
 * @author Juvenal Carlos Cardo
 */
public interface ProdutoDao {
    
    boolean salvar(Produto produto);
    Produto buscarPorcodigo(int codigo);
    boolean deletar(Produto produto);
    boolean atualizar(Produto produto);
}
