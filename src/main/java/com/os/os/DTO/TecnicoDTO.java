package com.os.os.DTO;

import com.os.os.Domain.Tecnico;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

public class TecnicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "O campo NOME não pode ser nulo")
    private String nome;
    @NotEmpty(message = "O campo TELEFONE não pode ser nulo")
    private String telefone;

    @CPF
    @NotEmpty(message = "O campo CPF não pode ser nulo")
    private String cpf;

    public TecnicoDTO() {
    }

    public TecnicoDTO(Tecnico tecnico) {
        this.id = tecnico.getId();
        this.nome = tecnico.getNome();
        this.cpf = tecnico.getCpf();
        this.telefone = tecnico.getTelefone();
    }

    public Integer getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
