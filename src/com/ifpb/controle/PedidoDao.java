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
 * @author Juvenal Carlos Cardo
 */
public interface PedidoDao {
    public boolean salvarPedido (Pedido pedido);
    public boolean atualizarPedido(Pedido velho, Pedido novo);
    public boolean removerPedido (Pedido pedido);
    public Set<Pedido> getPedidos();
    public Set<Pedido> getPedidoMesa(int mesa);
    public double valorTotal(int mesa);
}
