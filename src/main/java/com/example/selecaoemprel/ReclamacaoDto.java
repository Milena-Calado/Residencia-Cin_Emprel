package com.example.selecaoemprel;


import java.io.Serializable;

public class ReclamacaoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String cpf;
    private static String reclam;
    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public static String getReclam() {
        return reclam;
    }

    public void setReclam(String reclam) {
        ReclamacaoDto.reclam = reclam;
    }

    public Long getId() {
        return null;
    }
    
}
