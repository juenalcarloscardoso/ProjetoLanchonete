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
 * Classe onde todos os métodos devem ser implementados
 * @author Juvenal Carlos Cardoso
 */
public class PedidoDaoCollection implements PedidoDao {
    
    private Set<Pedido> pedidos;
    private Set<Pedido> pedidosMesa;
    private File arquivo;
    
    /**
     *  Construtor do arquivo e de pedido.
     * @throws IOException /
     */
    public PedidoDaoCollection() throws IOException{
        arquivo = new File("Pedidos");
        pedidos = new HashSet<>();
        
        if(!arquivo.exists()){
            arquivo.createNewFile();
        }
    }
    /**
     * Método para lista pedidos.
      
     */
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
    
    /**
     * Método para salvar pedido.
     * @param pedido representa o pedido solicitado pelo usuáriuo
     * @return true ou false;
     */
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
    /**
     * Método para atualizar pedido
     * @param velho representa pedido velho
     * @param novo representa pedido novo
     * @return true ou false;
     */
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
    /**
     * Método para remover pedido
     * @param pedido representa pedido a ser deletado
     * @return true po false;
     */
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
   /**
    * Método para verificar se o número de mesa é igual ao número de mesa do pedido e adicionar o pedido a mesa solicitante.
    * @param mesa represnta o número da mesa
    * @return pedidosMesa;
    */
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
   /**
     * Método para somar o valor total que foi consumidor na mesa.
     * @param mesa representa o número da mesa
     * @return total;
     */
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
    /**
     * Método para atualizar o subtotal consumido pelo criente.
     * @param pedidos  representa uma conjunto de pedidos
     */
    private void atualizarSubtotal(Set<Pedido> pedidos){
        for(Pedido pedido : pedidos){
            pedido.setSubtotal(pedido.getQuantidade() *pedido.getProduto().getPreco());
        }
    }
   /**
    * Método para atualizar o arquivo onde esta armazenado todos os pedidos dos clientes.
    * @param pedidos representa um conjunto de pedidos
    */
    private void atualizarArquivo(Set<Pedido> pedidos) throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
        out.writeObject(pedidos);
    }
}
