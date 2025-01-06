package com.forohub.forohub.controller;

import com.forohub.forohub.model.topico.DatosListadoTopico;
import com.forohub.forohub.model.topico.DatosRegistroTopico;
import com.forohub.forohub.repository.TopicoRepository;
import com.forohub.forohub.model.topico.DatosRespuestaTopico;
import com.forohub.forohub.model.topico.Topico;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;



@RestController
@RequestMapping("/topico")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;
    
    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder) {
        Topico topicoRegistrado = topicoRepository.save(new Topico(datosRegistroTopico));
       DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topicoRegistrado.getId(),topicoRegistrado.getTitulo(),topicoRegistrado.getMensaje(),
               topicoRegistrado.getFechaCreacion(),topicoRegistrado.getStatus(),topicoRegistrado.getUsuarioId(),topicoRegistrado.getCursoId());
       URI url = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(topicoRegistrado.getId()).toUri();
       return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopico(@PageableDefault(size = 2) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion(),
                topico.getStatus(),topico.getUsuarioId(),topico.getCursoId());
        return ResponseEntity.ok(datosTopico);
    }


}
