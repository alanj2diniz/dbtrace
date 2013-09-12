package org.dbtrace.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
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
    @NotNull
    private String senha;
    
    @Transient
    private String novaSenha;
    
    @Transient
    private String confirmaSenha;

    protected Usuario() {
    }

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    
    public boolean isConfirmaSenha() {
        return this.senha.equals(this.confirmaSenha);
    }
    
    public boolean isNovaSenhaValida() {
        return this.senha.equals(this.novaSenha);
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    
    
    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public String getNovaSenha() {
        return novaSenha;
    }
    
    

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }
    
    
    
    
    
}