package br.com.mrg.dbtracemodel.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "MODULO")
public class Modulo extends AbstractEntity {

    @Column(name = "nome")
    @NotNull(message = "Nome obrigatório")
    @Size(max = 200,  message = "Nome não pode ser maior que 200 caracteres")
    private String nome;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "MODULO_REPOSITORIO",
            joinColumns =
            @JoinColumn(name = "MODULO_ID", referencedColumnName = "ID"),
            inverseJoinColumns =
            @JoinColumn(name = "REPOSITORIO_ID", referencedColumnName = "ID"))
    private Set<Repositorio> repositorios;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Repositorio> getRepositorios() {
        return repositorios;
    }

    public void setRepositorios(Set<Repositorio> repositorios) {
        this.repositorios = repositorios;
    }
    
}