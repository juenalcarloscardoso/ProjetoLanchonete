/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ProdutoDao;
import controle.ProdutoDaoCollection;
import java.time.LocalDate;
import java.time.Month;
import modelo.Produto;

/**
 *
 * @author Juvenal Carlos Cardo
 */
public class App {
    
    public static void main(String[] args) {
        ProdutoDao dao = new ProdutoDaoCollection();
        Produto p1 = new Produto(1,"Arraoiz","ab",3,LocalDate.of(2019, 5, 1));
        dao.salvar(p1);
        System.out.println(dao.buscarPorcodigo(1));
    }
    
}
