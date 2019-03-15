/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controle;

import com.ifpb.modelo.Pedido;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Juvenal Carlos Cardo
 */
public class PedidoDaoCollection implements PedidoDao {
    
    private Set<Pedido> pedidos;
    private Set<Pedido> pedidosMesa;
    
    public PedidoDaoCollection(){
        pedidos = new HashSet<>();
    }
    
    
    @Override
    public boolean salvarPedido (Pedido pedido){
        if(pedidos.add(pedido)){
           atualizarSubtotal(pedidos);
           return true;
        }
        return false;
    }
    @Override
    public boolean atualizarPedido(Pedido velho, Pedido novo){
        if((pedidos.remove(velho)) && (pedidos.add(novo))){
            atualizarSubtotal(pedidos);
            return true;
        } else{
            return false;
        }
    }
    @Override
    public boolean removerPedido (Pedido pedido){
        return pedidos.remove(pedido);
    }
    @Override
    public Set<Pedido> getPedidos(){
        return pedidos;
    }
    @Override
    public Set<Pedido> getPedidoMesa(int mesa){
        Set<Pedido> pedidos = getPedidos();
        Set<Pedido> pedidosMesa = new HashSet<>();
       for (Pedido pedido : pedidos){
            if(pedido.getNumMesa() == mesa){
                pedidosMesa.add(pedido);
            }
        }
        return pedidosMesa;
      
        
    }
   
    @Override
    public double valorTotal(int mesa){
       double total = 0;
       for(Pedido pedido : pedidos){
           if((pedido.getNumMesa() == mesa)&&(pedido.isStatus() == false)){
               total += (pedido.getProduto().getPreco()*pedido.getQuantidade());
               pedido.setStatus(true);
               
           }
       }
       return total;
   }
    
    private void atualizarSubtotal(Set<Pedido> pedidos){
        for(Pedido pedido : pedidos){
            pedido.setSubtotal(pedido.getQuantidade() *pedido.getProduto().getPreco());
        }
    }
}
