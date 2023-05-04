package com.os.os.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.os.os.Domain.Cliente;
import com.os.os.Domain.Enums.Prioridade;
import com.os.os.Domain.Enums.Status;
import com.os.os.Domain.OrdemServico;
import com.os.os.Domain.Tecnico;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class OrdemServicoDTO {

    private Integer id;

    private LocalDateTime dataAbertura;

    private LocalDateTime dataFechamento;
    private Integer prioridade;
    private String observacoes;
    private Integer status;

    private Integer tecnico;

    private Integer cliente;

    public OrdemServicoDTO(){

    }

    public OrdemServicoDTO(OrdemServico os) {
        this.id = os.getId();
        this.dataAbertura = os.getDataAbertura();
        this.dataFechamento = os.getDataFechamento();
        this.prioridade = (os.getPrioridade().getCod() == null ? 0 : os.getPrioridade().getCod());
        this.observacoes = os.getObservacoes();
        this.status = (os.getStatus().getCod() == null ? 0 : os.getStatus().getCod());
        this.tecnico = os.getTecnico().getId();
        this.cliente = os.getCliente().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDateTime dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTecnico() {
        return tecnico;
    }

    public void setTecnico(Integer tecnico) {
        this.tecnico = tecnico;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }
}
