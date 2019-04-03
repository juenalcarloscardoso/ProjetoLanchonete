/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe que possui os pedidos que estão na cozinha.
 * @author Juvenal Carlos Cardoso
 */
public class Cozinha implements Serializable {
    private List<Pedido> pedidos;
    /**
     * Construtor da classe cozinha
     * @param pedidos representa um conjunto de pedidos
     */
     public Cozinha(List<Pedido> pedidos) {
        this.pedidos = new ArrayList<>();
    }
    /**
     * Abaixo estão todos os Sets e Gets da classe cozinha.
     * @param pedido represnta um conjunto de pedidos
     */
    public void setPedido(Pedido pedido) {
       pedidos = new ArrayList<>();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.pedidos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cozinha other = (Cozinha) obj;
        if (!Objects.equals(this.pedidos, other.pedidos)) {
            return false;
        }
        return true;
    }
    
    

    
    
    
    
}
