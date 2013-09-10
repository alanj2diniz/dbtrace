package br.com.mrg.dbtracemodel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "USUARIO")
public class Usuario extends AbstractEntity {
    
    @Column(name = "nome")
    @NotNull(message = "Nome obrigatório")
    @Size(max = 200, message = "O nome não pode ter mais que 200 caracteres")
    private String nome;
    
    @Column(name = "login")
    @NotNull(message = "Login obrigatório")
    @Size(max = 100, message = "Login não pode ser maior que 100 caracteres")
    private String login;
    
    @Column(name = "senha")
    @NotNull(message = "Senha obrigatória")
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}