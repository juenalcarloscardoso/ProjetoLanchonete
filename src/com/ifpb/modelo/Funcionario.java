/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.modelo;


import com.ifpb.enumerations.Setor;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Juvenal Carlos Cardo
 */
public class  Funcionario implements Serializable {
    
    private String cpf;
    private String nome;
    private String email;
    private String fone;
    private LocalDate dataNascimento;
    private Setor setor;
    private String usuario;
    private String senha;
    
    

//private Setor setor;
    public Funcionario(String cpf){
        this.cpf = cpf;
    }

    public Funcionario(String cpf, String nome, String email, String fone, LocalDate dataNascimento, Setor setor, String usuario, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.fone = fone;
        this.dataNascimento = dataNascimento;
        this.setor = setor;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.cpf);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", fone=" + fone + ", dataNascimento=" + dataNascimento + ", setor=" + setor + ", usuario=" + usuario + ", senha=" + senha + '}';
    }

    
    
    

   
    

    
    
    
    
}
