package com.os.os;

import com.os.os.Domain.Cliente;
import com.os.os.Domain.Enums.Prioridade;
import com.os.os.Domain.Enums.Status;
import com.os.os.Domain.OrdemServico;
import com.os.os.Domain.Tecnico;
import com.os.os.Repository.ClienteRepository;
import com.os.os.Repository.OrdemServicoRepository;
import com.os.os.Repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class OsApplication  {



	public static void main(String[] args) {
		SpringApplication.run(OsApplication.class, args);
	}


}
