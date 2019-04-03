/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.modelo;

import java.io.Serializable;
import java.time.LocalDate;
//import java.util.concurrent.atomic.AtomicInteger;

/**
 * Classe que possui os dados do produtos
 * @author Juvenal Carlos Cardoso
 */
public class Produto implements Serializable{

    //private static final AtomicInteger count = new AtomicInteger(0);
    
    private int codigo;
    private String nome;
    private String descricao;
    private double preco;
    
     
    /*public Produto(int codigo){
        this.codigo = codigo;
    }
    */
    /**
     * Construtor de produtos.
     * @param codigo representa o codigo do produto
     * @param nome  represnta o nome do produto
     * @param descricao representa a descrição do produto
     * @param preco representa o valor total do produto
     */
    public Produto(int codigo, String nome, String descricao, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        
    }
  
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + '}';
    }

    
  
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.codigo;
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
        final Produto other = (Produto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    
    

   
    
}
