package com.os.os.Controller;

import com.os.os.DTO.OrdemServicoDTO;
import com.os.os.DTO.TecnicoDTO;
import com.os.os.Domain.OrdemServico;
import com.os.os.Service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
}
