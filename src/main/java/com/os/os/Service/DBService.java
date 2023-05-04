package com.os.os.Service;

import com.os.os.Domain.Cliente;
import com.os.os.Domain.Enums.Prioridade;
import com.os.os.Domain.Enums.Status;
import com.os.os.Domain.OrdemServico;
import com.os.os.Domain.Tecnico;
import com.os.os.Repository.ClienteRepository;
import com.os.os.Repository.OrdemServicoRepository;
import com.os.os.Repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    public void instanciaDB(){

        Tecnico t1 = new Tecnico(null,"TESTE 1","140.006.230-60","18997820645");
        Cliente c1 = new Cliente(null,"TESTE 2","738.854.880-78","148746445454");
        OrdemServico os = new OrdemServico(null, Prioridade.BAIXA,"esse é um teste", Status.ABERTO,t1,c1);

        t1.getList().add(os);
        c1.getList().add(os);

        tecnicoRepository.saveAll(Arrays.asList(t1));
        clienteRepository.saveAll(Arrays.asList(c1));
        ordemServicoRepository.saveAll(Arrays.asList(os));

    }
}
