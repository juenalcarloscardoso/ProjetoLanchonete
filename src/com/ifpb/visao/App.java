/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.visao;

import com.ifpb.controle.ProdutoDao;
import com.ifpb.controle.ProdutoDaoCollection;
import com.ifpb.modelo.Produto;
import java.io.IOException;

/**
 *
 * @author Juvenal Carlos Cardo
 */
public class App {
    
    public static void main(String[] args) throws IOException {
        
        ProdutoDao dao = new ProdutoDaoCollection();
        Produto p1 = new Produto(1,"Batata frita","Porção de batata frita com molho",3.50);
        Produto p2 = new Produto(2," X-Salada ","Pão de hamburguer,queijo,alface,maionese,tomate",2.50);
        Produto p3 = new Produto(3," Big burguer","Pão amburguer,creme de milho,queijo,bacon",4.50);
        
        dao.salvar(p1);
        dao.salvar(p2);
        dao.salvar(p3);
        
        
    }
    
}
