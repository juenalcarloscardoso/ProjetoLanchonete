/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controle;

import com.ifpb.modelo.Comanda;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Juvenal Carlos Cardo
 */
public class ComandaDaoCollection implements ComandaDao {
    
    private Set<Comanda> comandas;
    
    public ComandaDaoCollection (){
        comandas = new HashSet<>();
    }
    
    @Override
    public boolean temComanda(int mesa){
        Comanda auxliar = new Comanda( mesa);
        if(comandas.contains(mesa)){
            return true;
        }else{
         return false;
    }
        
    }
    
    @Override
     public boolean salvarComanda(Comanda comanda){
         return comandas.add(comanda);
     }
     
    
    @Override
 public boolean atualizarComanda(Comanda novacomanda, int mesaAntiga){
       
         for(Comanda c: comandas){
             if(c.getNumMesa() == mesaAntiga){
                 comandas.remove(c);
                 comandas.add(novacomanda);
                 return true;
             }
         }
         return false;
     }
 
    @Override
 public boolean deletaComanda(int mesa){
     for(Comanda c: comandas){
         if(c.getNumMesa()== mesa){
             comandas.remove(c);
             return true;
         }
     }
     return false;
 }
    @Override
  public   Set<Comanda> getComanda(){
     return comandas;
 }
    
    
}
