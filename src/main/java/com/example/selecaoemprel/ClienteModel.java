package com.example.selecaoemprel;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ClienteModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cpf;

    @OneToMany(targetEntity = ReclamacaoModel.class, mappedBy = "cliente")
    private List<ReclamacaoModel> reclamacoes;

    public ClienteModel() {
    }

    public ClienteModel(String cpf) {
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<ReclamacaoModel> getReclamacoes() {
        return reclamacoes;
    }

    public void addReclamacoes(ReclamacaoModel reclamacao) {
        reclamacoes.add(reclamacao);
    }
}
