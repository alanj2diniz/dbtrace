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

@Entity(name = "REPOSITORIO")
public class Repositorio extends AbstractEntity {

    @Column(name = "nome")
    @NotNull(message = "Nome obrigatório")
    @Size(max = 200,  message = "Nome não pode ser maior que 200 caracteres")
    private String nome;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "REPOSITORIO_TABELA",
            joinColumns =
            @JoinColumn(name = "REPOSITORIO_ID", referencedColumnName = "ID"),
            inverseJoinColumns =
            @JoinColumn(name = "TABELA_ID", referencedColumnName = "ID"))
    private Set<Tabela> tabelas;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "repositorios")
    private Set<Modulo> modulos;

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }
   
    public Set<Tabela> getTabelas() {
        return tabelas;
    }

    public void setTabelas(Set<Tabela> tabelas) {
        this.tabelas = tabelas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}