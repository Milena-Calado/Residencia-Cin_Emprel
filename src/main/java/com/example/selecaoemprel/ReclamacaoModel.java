package com.example.selecaoemprel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ReclamacaoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cpf;
    @Column
    private String protocolo;
    @Column
    private String reclam;

    @ManyToOne(targetEntity = ClienteModel.class)
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    public ReclamacaoModel() {
    }

    public ReclamacaoModel(Long id, String cpf, String protocolo, String reclam, ClienteModel cliente) {
        this.id = id;
        this.cpf = cpf;
        this.protocolo = protocolo;
        this.reclam = reclam;
        this.cliente = cliente;
        
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

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getReclam() {
        return reclam;
    }

    public void setReclam(String reclam) {
        this.reclam = reclam;
    }

    public void setCliente(ClienteModel cliente2) {
    }
}