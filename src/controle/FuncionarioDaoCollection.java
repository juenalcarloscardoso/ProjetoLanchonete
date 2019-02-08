/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.HashSet;
import java.util.Set;
import modelo.Funcionario;

/**
 *
 * @author Juvenal Carlos Cardo
 */
public class FuncionarioDaoCollection implements  FuncionarioDao {
    private Set<Funcionario> funcionarios;
    
    public FuncionarioDaoCollection(){
        funcionarios = new HashSet<>();
    }
    
    @Override
    public boolean salvarFunc(Funcionario funcionario){
        return funcionarios.add(funcionario);
    }
    @Override
    public boolean edititarFunc(Funcionario funcionario){
        Funcionario auxiliar = new Funcionario(funcionario.getCpf());
        if(funcionarios.contains(auxiliar)){
            return funcionarios.remove(auxiliar) && funcionarios.add(funcionario);
        }else{
            return false;
        }
    }
    
    
    
}
