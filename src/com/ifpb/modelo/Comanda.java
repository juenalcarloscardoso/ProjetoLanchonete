/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.modelo;


import java.io.Serializable;
import java.util.Objects;
import java.util.Set;


/**
 *
 * @author Juvenal Carlos Cardo
 */
public class Comanda implements Serializable {

    private Set<Pedido> pedidos;
    private int numMesa;
    
    public Comanda() {
    }

    public Comanda(Set<Pedido> pedidos, int numMesa) {
        this.pedidos = pedidos;
        this.numMesa = numMesa;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.pedidos);
        hash = 41 * hash + this.numMesa;
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
        final Comanda other = (Comanda) obj;
        if (this.numMesa != other.numMesa) {
            return false;
        }
        if (!Objects.equals(this.pedidos, other.pedidos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comanda{" + "pedidos=" + pedidos + ", numMesa=" + numMesa + '}';
    }

    
    

}
