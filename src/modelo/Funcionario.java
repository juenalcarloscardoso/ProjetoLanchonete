/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancchonete.entindades;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Juvenal Carlos Cardo
 */
public class  Funcionario implements Serializable{
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private Setor setor;

    public Funcionario(int id, String nome, String cpf, String email, LocalDate dataNascimento, String senha,String setor) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.setor = Setor.valueOf(setor);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setSetor(String setor) {
          this.setor = Setor.valueOf(setor);
    }

    public Setor getSetor() {
        return setor;
    }
    

    @Override
    public String toString() {
        return "Funcionario{" + "id=" + id + ", nome=" + nome + 
                ", cpf=" + cpf + ", email=" + email + ", dataNascimento=" + dataNascimento + '}';
    }
    
    
    
}
