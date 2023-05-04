package com.os.os.Service;

import com.os.os.DTO.ClienteDTO;
import com.os.os.Domain.Pessoa;
import com.os.os.Domain.Cliente;
import com.os.os.Exceptions.DataIntegratyViolationException;
import com.os.os.Exceptions.ObjectNotFoundException;
import com.os.os.Repository.PessoaRepository;
import com.os.os.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    public Cliente findById(Integer id){

        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException("Cliente de ID "+id+" não foi encontrado"));

    }

    public List<Cliente> getAll(){

        return clienteRepository.findAll();
    }

    public Cliente create(ClienteDTO clienteDTO) {
        if(findByCPF(clienteDTO) != null){
            throw new DataIntegratyViolationException("CPF já cadastrado");
        }
        return clienteRepository.save(new Cliente(null,clienteDTO.getNome(),clienteDTO.getCpf(),clienteDTO.getTelefone()));
    }

    private Pessoa findByCPF(ClienteDTO clienteDTO){
        Pessoa pessoa = pessoaRepository.findByCPF(clienteDTO.getCpf());
        if(pessoa !=null){
            return pessoa;
        }
        return null;
    }

    public Cliente update(Integer id, ClienteDTO clienteDTO) {
        Cliente cliente = findById(id);
        if(findByCPF(clienteDTO) !=null && findByCPF(clienteDTO).getId() != id ){
            throw new DataIntegratyViolationException("CPF já cadastrado");
        }
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setTelefone(clienteDTO.getTelefone());
        return clienteRepository.save(cliente);
    }

    public void delete(Integer id) {
        Cliente cliente = findById(id);
        if(cliente.getList().size() > 0){
            throw new DataIntegratyViolationException("Cliente possui ordens de serviço vinculadas");
        }
        clienteRepository.deleteById(id);

    }
}
