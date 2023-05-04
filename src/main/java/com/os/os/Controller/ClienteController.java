package com.os.os.Controller;

import com.os.os.DTO.ClienteDTO;
import com.os.os.Domain.Cliente;
import com.os.os.Service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @GetMapping(path = "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id){
        ClienteDTO cliente = new ClienteDTO(clienteService.findById(id));
        return ResponseEntity.ok().body(cliente);

    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll(){
        List<ClienteDTO> listDTO = clienteService.getAll().
                stream().map(x-> new ClienteDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO clienteDTO){
        Cliente cliente = clienteService.create(clienteDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Integer id, @Valid @RequestBody ClienteDTO clienteDTO){
        ClienteDTO newClienteDTO = new ClienteDTO(clienteService.update(id,clienteDTO));
        return ResponseEntity.ok().body(clienteDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Integer id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
