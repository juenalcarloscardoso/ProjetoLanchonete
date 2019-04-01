/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controle;

import com.ifpb.modelo.Pedido;
import java.util.Set;

/**
 *
 * @author Juvenal Carlos Cardoso
 */
public interface PedidoDao {
    /**
     * Método para salvar pedido.
     * @param pedido
     * @return true ou false;
     */
    public boolean salvarPedido (Pedido pedido);
    /**
     * Método para atualizar pedido
     * @param velho
     * @param novo
     * @return true ou false;
     */
    public boolean atualizarPedido(Pedido velho, Pedido novo);
    /**
     * Método para remover pedido
     * @param pedido
     * @return true po false;
     */
    public boolean removerPedido (Pedido pedido);
    /**
     * Método para lista pedidos.
     * @return 
     */
    public Set<Pedido> getPedidos();
    /**
     * Método para listar mesa.
     * @param mesa
     * @return 
     */
    public Set<Pedido> getPedidoMesa(int mesa);
    /**
     * Método para somar o valor total que foi consumidor na mesa.
     * @param mesa
     * @return 
     */
    public double valorTotal(int mesa);
}
