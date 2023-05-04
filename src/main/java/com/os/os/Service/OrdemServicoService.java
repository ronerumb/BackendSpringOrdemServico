package com.os.os.Service;

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

    public OrdemServico findById(Integer id){
       Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(id);
       return ordemServico.orElseThrow(()-> new ObjectNotFoundException("Ordem de serviço não encontrada"));


    }

    public List<OrdemServico> getAll(){
       return ordemServicoRepository.findAll();

    }
}
