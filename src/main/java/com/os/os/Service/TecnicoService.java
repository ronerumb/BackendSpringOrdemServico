package com.os.os.Service;

import com.os.os.DTO.TecnicoDTO;
import com.os.os.Domain.Pessoa;
import com.os.os.Domain.Tecnico;
import com.os.os.Exceptions.DataIntegratyViolationException;
import com.os.os.Exceptions.ObjectNotFoundException;
import com.os.os.Repository.PessoaRepository;
import com.os.os.Repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    public Tecnico findById(Integer id){

        Optional<Tecnico> tecnico = tecnicoRepository.findById(id);
        return tecnico.orElseThrow(() -> new ObjectNotFoundException("Cliente de ID "+id+" não foi encontrado"));

    }

    public List<Tecnico> getAll(){

        return tecnicoRepository.findAll();
    }

    public Tecnico create(TecnicoDTO tecnicoDTO) {
        if(findByCPF(tecnicoDTO) != null){
            throw new DataIntegratyViolationException("CPF já cadastrado");
        }
        return tecnicoRepository.save(new Tecnico(null,tecnicoDTO.getNome(),tecnicoDTO.getCpf(),tecnicoDTO.getTelefone()));
    }

    private Pessoa findByCPF(TecnicoDTO tecnicoDTO){
        Pessoa pessoa = pessoaRepository.findByCPF(tecnicoDTO.getCpf());
        if(pessoa !=null){
            return pessoa;
        }
        return null;
    }

    public Tecnico update(Integer id, TecnicoDTO tecnicoDTO) {
        Tecnico tecnico = findById(id);
        if(findByCPF(tecnicoDTO) !=null && findByCPF(tecnicoDTO).getId() != id ){
            throw new DataIntegratyViolationException("CPF já cadastrado");
        }
        tecnico.setNome(tecnicoDTO.getNome());
        tecnico.setCpf(tecnicoDTO.getCpf());
        tecnico.setTelefone(tecnicoDTO.getTelefone());
        return tecnicoRepository.save(tecnico);
    }

    public void delete(Integer id) {
        Tecnico tecnico = findById(id);
        if(tecnico.getList().size() > 0){
            throw new DataIntegratyViolationException("Tecnico possui ordens de serviço vinculadas");
        }
        tecnicoRepository.deleteById(id);

    }
}
