package com.forohub.forohub.controller;

import com.forohub.forohub.infra.rules.TopicoService;
import com.forohub.forohub.model.topico.*;
import com.forohub.forohub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
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
    @Autowired
    private TopicoService topicoService;
    
    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder) {
       Topico topicoRegistrado = topicoService.registrarTopico(datosRegistroTopico);
       return topicoService.detalleTopico(topicoRegistrado, uriComponentsBuilder);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopico(@PageableDefault(size = 2) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        return topicoService.modificaTopico(datosActualizarTopico);
    //    Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
    //    topico.actualizarDatos(datosActualizarTopico);
    //    return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion(),
    //            topico.getStatus(),topico.getUsuarioId(),topico.getCursoId()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id) {
        return topicoService.consultaTopico(id);
    //    Topico topico = topicoRepository.getReferenceById(id);
    //    var datosTopico = new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion(),
    //            topico.getStatus(),topico.getUsuarioId(),topico.getCursoId());
    //    return ResponseEntity.ok(datosTopico);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void  eliminarMedico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }
}
