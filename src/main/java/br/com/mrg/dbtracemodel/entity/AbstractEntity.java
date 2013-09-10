package br.com.mrg.dbtracemodel.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.joda.time.DateTime;

@MappedSuperclass
public class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Version
    @Column(name = "version")
    @NotNull
    private int version = 0;
    
    @Column(name = "data_criacao")
    @NotNull
    private DateTime dataCriacao = DateTime.now();
    
    private boolean ativo = true;

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getVersion() {
        return version;
    }

    public DateTime getDataCriacao() {
        return dataCriacao;
    }

    public Long getId() {
        return id;
    }
}