package com.os.os.Config;

import com.os.os.Domain.Cliente;
import com.os.os.Domain.Enums.Prioridade;
import com.os.os.Domain.Enums.Status;
import com.os.os.Domain.OrdemServico;
import com.os.os.Domain.Tecnico;
import com.os.os.Repository.ClienteRepository;
import com.os.os.Repository.OrdemServicoRepository;
import com.os.os.Repository.TecnicoRepository;
import com.os.os.Service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public void instanciaDB(){
    this.dbService.instanciaDB();

    }
}
