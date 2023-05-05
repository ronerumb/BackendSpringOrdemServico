package com.os.os.Controller;

import com.os.os.DTO.OrdemServicoDTO;
import com.os.os.DTO.TecnicoDTO;
import com.os.os.Domain.OrdemServico;
import com.os.os.Service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/os")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<OrdemServicoDTO> findById(@PathVariable Integer id){
        OrdemServicoDTO ordemServicoDTO = new OrdemServicoDTO(ordemServicoService.findById(id));
        return ResponseEntity.ok().body(ordemServicoDTO);
    }

    @GetMapping
    public ResponseEntity<List<OrdemServicoDTO>> findAll(){
        List<OrdemServicoDTO> listDTO = ordemServicoService.getAll().
                stream().map(x-> new OrdemServicoDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<OrdemServicoDTO> create(@RequestBody OrdemServicoDTO ordemServicoDTO){
        OrdemServico ordemServico = ordemServicoService.create(ordemServicoDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(ordemServico.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<OrdemServicoDTO> update (@PathVariable Integer id, @RequestBody OrdemServicoDTO ordemServicoDTO){
        OrdemServicoDTO newOrdemServicoDTO = new OrdemServicoDTO(ordemServicoService.update(id,ordemServicoDTO));
        return ResponseEntity.ok().body(newOrdemServicoDTO);
    }
}
