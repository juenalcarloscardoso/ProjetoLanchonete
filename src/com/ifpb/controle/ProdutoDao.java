/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controle;

import com.ifpb.modelo.Produto;
import java.util.Set;

/**
 * Classe que representa todos os métodos abstratos que devem ser implementados na classe ProdutoDaoCollection
 * @author Juvenal Carlos Cardoso
 */
public interface ProdutoDao {
    
    boolean salvar(Produto produto);
    boolean buscarPorcodigo(int codigo);
    boolean deletar(int codigo);
    boolean atualizar(Produto produto,int codigo);
    public Set<Produto> getProdutos();
}
