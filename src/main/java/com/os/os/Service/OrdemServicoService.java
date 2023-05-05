package com.os.os.Service;

import com.os.os.DTO.OrdemServicoDTO;
import com.os.os.Domain.Enums.Prioridade;
import com.os.os.Domain.Enums.Status;
import com.os.os.Domain.OrdemServico;
import com.os.os.Exceptions.ObjectNotFoundException;
import com.os.os.Repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdemServicoService {


    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private  TecnicoService tecnicoService;

    public OrdemServico findById(Integer id){
       Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(id);
       return ordemServico.orElseThrow(()-> new ObjectNotFoundException("Ordem de serviço não encontrada"));


    }

    public List<OrdemServico> getAll(){
       return ordemServicoRepository.findAll();

    }

    public OrdemServico create(OrdemServicoDTO ordemServicoDTO) {
        OrdemServico ordemServico = new OrdemServico();
        ordemServico.setObservacoes(ordemServicoDTO.getObservacoes());
        ordemServico.setStatus(Status.toEnum(ordemServicoDTO.getStatus()));
        ordemServico.setPrioridade(Prioridade.toEnum(ordemServicoDTO.getPrioridade()));
        ordemServico.setCliente(clienteService.findById(ordemServicoDTO.getCliente()));
        ordemServico.setTecnico(tecnicoService.findById(ordemServicoDTO.getTecnico()));
        return ordemServicoRepository.save(ordemServico);
    }

    public OrdemServico update(Integer id, OrdemServicoDTO ordemServicoDTO) {

        OrdemServico ordemServico = findById(id);
        ordemServico.setObservacoes(ordemServicoDTO.getObservacoes());
        ordemServico.setStatus(Status.toEnum(ordemServicoDTO.getStatus()));
        ordemServico.setPrioridade(Prioridade.toEnum(ordemServicoDTO.getPrioridade()));
        ordemServico.setCliente(clienteService.findById(ordemServicoDTO.getCliente()));
        ordemServico.setTecnico(tecnicoService.findById(ordemServicoDTO.getTecnico()));
        return ordemServicoRepository.save(ordemServico);
    }
}
