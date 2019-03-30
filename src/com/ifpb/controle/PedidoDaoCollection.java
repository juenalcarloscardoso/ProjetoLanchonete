/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controle;

import com.ifpb.modelo.Pedido;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juvenal Carlos Cardo
 */
public class PedidoDaoCollection implements PedidoDao {
    
    private Set<Pedido> pedidos;
    private Set<Pedido> pedidosMesa;
    private File arquivo;
    
    public PedidoDaoCollection() throws IOException{
        arquivo = new File("Pedidos");
        pedidos = new HashSet<>();
        
        if(!arquivo.exists()){
            arquivo.createNewFile();
        }
    }
    
    @Override
       public Set<Pedido> getPedidos(){
           if(arquivo.length()>0){
                ObjectInputStream in = null;
               try {
                   in = new ObjectInputStream(new FileInputStream(arquivo));
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(PedidoDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(PedidoDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
               }
               try {
                   return (Set<Pedido>) in.readObject();
               } catch (IOException ex) {
                   Logger.getLogger(PedidoDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(PedidoDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           return new HashSet<>();
       }
    
    
    @Override
    public boolean salvarPedido (Pedido pedido){
        Set<Pedido> pedidos = getPedidos();
        if(pedidos.add(pedido)){
            atualizarSubtotal(pedidos);
            try {
                atualizarArquivo(pedidos);
            } catch (IOException ex) {
                Logger.getLogger(PedidoDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
            }
           return true;
        }
        return false;
    }
   
    @Override
    public boolean atualizarPedido(Pedido velho, Pedido novo){
        Set<Pedido> pedidos = getPedidos();
        if((pedidos.remove(velho)) && (pedidos.add(novo))){
            atualizarSubtotal(pedidos);
            try {
                atualizarArquivo(pedidos);
            } catch (IOException ex) {
                Logger.getLogger(PedidoDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        } else{
            return false;
        }
    }
    @Override
    public boolean removerPedido(Pedido pedido){
         Set<Pedido> pedidos = getPedidos();
         if(pedidos.remove(pedido)){
             try {
                 atualizarArquivo(pedidos);
             } catch (IOException ex) {
                 Logger.getLogger(PedidoDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
             }
             return true;
         }else{
             return false;
         }
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
        Set<Pedido> pedidos = getPedidos();
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

    private void atualizarArquivo(Set<Pedido> pedidos) throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
        out.writeObject(pedidos);
    }
}
