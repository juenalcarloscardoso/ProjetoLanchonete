/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import modelo.StatusPedido;

/**
 *
 * @author Juvenal Carlos Cardo
 */
public class Pedido {

    private Produto produto;
    private int quantidade;
    private LocalDateTime dataHora;
    private double subRotal;
    private StatusPedido status;

    public Pedido() {
        this.quantidade = 1;
        this.dataHora = LocalDateTime.now();
    }

    public Pedido(Produto produto, int quantidade, LocalDateTime dataHora) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.dataHora = dataHora;
        this.status = status.NAOATENDIDO;
        calculatSubTotal();

    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        calculatSubTotal();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public double getSubRotal() {
        return subRotal;
    }

    public void setSubRotal(double subRotal) {
        this.subRotal = subRotal;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return "Pedido{" + "produto= " + produto + ","
                + " quantidade= " + quantidade + ", dataHora= " + dataHora.format(formatter) + " subTotal= " + subRotal + '}';
    }

    private void calculatSubTotal() {
        this.subRotal = this.produto.getPreco() * this.quantidade;
    }

}
