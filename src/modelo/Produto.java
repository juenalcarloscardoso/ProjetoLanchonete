/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancchonete.entindades;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Juvenal Carlos Cardo
 */
public class Produto {

    private static final AtomicInteger count = new AtomicInteger(0);
    private int codigo;
    private String nome;
    private String descricao;
    private double preco;

    public Produto() {
        this.codigo = count.incrementAndGet();
    }

    public Produto(String nome, String descricao, double preco) {
        this.nome = nome;
        this.codigo = count.incrementAndGet();
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
        return "Produto{" + "codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + '}';
    }

}
