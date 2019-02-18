/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.visao;

import com.ifpb.controle.FuncionarioDao;
import com.ifpb.controle.FuncionarioDaoCollection;
import com.ifpb.controle.ProdutoDao;
import com.ifpb.controle.ProdutoDaoCollection;
import java.time.LocalDate;
import java.time.Month;
import com.ifpb.modelo.Cozinha;
import com.ifpb.modelo.Funcionario;
import com.ifpb.modelo.Produto;

/**
 *
 * @author Juvenal Carlos Cardo
 */
public class App {
    
    public static void main(String[] args) {
        ProdutoDao dao = new ProdutoDaoCollection();
        Produto p1 = new Produto(1,"Arraoiz","ab",3,LocalDate.of(2019, 5, 1));
        FuncionarioDao d1 = new FuncionarioDaoCollection();
        
        Funcionario f = new Funcionario("123","juvenal","gmail.com","senha",LocalDate.of(1986, 3, 15));
       
        dao.salvar(p1);
        d1.salvarFunc(f);
        
        System.out.println(dao.buscarPorcodigo(1));
        System.out.println(d1.buscarPorCpf("123"));
      
       
        
        
    }
    
}
