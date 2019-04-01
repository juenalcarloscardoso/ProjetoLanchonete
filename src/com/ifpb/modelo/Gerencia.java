/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe de gerênciar as comandas.
 * @author Juvenal Carlos Cardoso
 */
public class Gerencia {
    
    private List<Comanda> comandas;
    /**
     * Construtor de comandas.
     */
    public Gerencia(){
        comandas = new ArrayList<>();
    }
    /**
     * Abaixo estão todos os Sets e Gets da classe gerência.
     * @return 
     */
    public List<Comanda> getComandas() {
        return comandas;
    }

    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.comandas);
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
        final Gerencia other = (Gerencia) obj;
        if (!Objects.equals(this.comandas, other.comandas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Gerencia{" + "comandas=" + comandas + '}';
    }
    
    
}
