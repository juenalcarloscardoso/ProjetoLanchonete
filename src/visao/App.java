/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.FuncionarioDao;
import controle.FuncionarioDaoCollection;
import controle.ProdutoDao;
import controle.ProdutoDaoCollection;
import java.time.LocalDate;
import java.time.Month;
import modelo.Funcionario;
import modelo.Produto;

/**
 *
 * @author Juvenal Carlos Cardo
 */
public class App {
    
    public static void main(String[] args) {
        ProdutoDao dao = new ProdutoDaoCollection();
        Produto p1 = new Produto(1,"Arraoiz","ab",3,LocalDate.of(2019, 5, 1));
        
         Funcionario d = new  Funcionario("1234","juvenal","juvenalfisica@live.com","1298",LocalDate.now());
        dao.salvar(p1);
        System.out.println(d);
        
    }
    
}
