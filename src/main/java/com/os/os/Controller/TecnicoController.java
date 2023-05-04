package com.os.os.Controller;

import com.os.os.DTO.TecnicoDTO;
import com.os.os.Domain.Tecnico;
import com.os.os.Service.TecnicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;
    @GetMapping(path = "/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){
        TecnicoDTO tecnico = new TecnicoDTO(tecnicoService.findById(id));
        return ResponseEntity.ok().body(tecnico);

    }

    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> getAll(){
        List<TecnicoDTO> listDTO = tecnicoService.getAll().
                stream().map(x-> new TecnicoDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<TecnicoDTO> create(@Valid @RequestBody TecnicoDTO tecnicoDTO){
        Tecnico tecnico = tecnicoService.create(tecnicoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(tecnico.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<TecnicoDTO> updateTecnico(@PathVariable Integer id, @Valid @RequestBody TecnicoDTO tecnicoDTO){
        TecnicoDTO newTecnicoDTO = new TecnicoDTO(tecnicoService.update(id,tecnicoDTO));
        return ResponseEntity.ok().body(tecnicoDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTecnico(@PathVariable Integer id){
        tecnicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
