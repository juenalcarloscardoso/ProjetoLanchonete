/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.enumerations;

/**
 *
 * @author Juvenal Carlos Cardo
 */
public enum Setor {
    COZINHA("COZINHA"), CAIXA("CAIXA"), GERENCIA("GERENCIA");
    private final String valor;

    private Setor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
}
