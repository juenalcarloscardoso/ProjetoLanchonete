/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Classe que descrever os dados do produto
 * @author Juvenal Carlos Cardosp
 */
public class Pedido implements Serializable {

     private Produto produto;
    private int quantidade;
    private LocalDate data;
    private LocalDateTime hora;
    private double subtotal;
    private boolean status;
    private int numMesa;
    

    public Pedido() {
       
    }
    /**
     * Construtor da classe pedidos
     * @param produto representa o produto da Lanchonete
     * @param quantidade representa a quantidade de produtos
     * @param data representa a data
     * @param hora representta a hora
     * @param numMesa  represnta o número de mesa
     */

    public Pedido(Produto produto, int quantidade, LocalDate data, LocalDate hora, int numMesa) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.data = LocalDate.now();
        this.hora = LocalDateTime.now();
        this.numMesa = numMesa;
        this.status = false;
    }
   
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
        hash = 23 * hash + Objects.hashCode(this.produto);
        hash = 23 * hash + this.quantidade;
        hash = 23 * hash + Objects.hashCode(this.data);
        hash = 23 * hash + Objects.hashCode(this.hora);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.subtotal) ^ (Double.doubleToLongBits(this.subtotal) >>> 32));
        hash = 23 * hash + (this.status ? 1 : 0);
        hash = 23 * hash + this.numMesa;
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
        final Pedido other = (Pedido) obj;
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (Double.doubleToLongBits(this.subtotal) != Double.doubleToLongBits(other.subtotal)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (this.numMesa != other.numMesa) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.hora, other.hora)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pedido{" + "produto=" + produto + ", quantidade=" + quantidade + ", data=" + data + ", hora=" + hora + ", subtotal=" + subtotal + ", status=" + status + ", numMesa=" + numMesa + '}';
    }
    

   
    
}
