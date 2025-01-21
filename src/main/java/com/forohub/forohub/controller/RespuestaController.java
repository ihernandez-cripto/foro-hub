package com.forohub.forohub.controller;

import com.forohub.forohub.model.respuesta.DatosDetalleRespuesta;
import com.forohub.forohub.model.respuesta.DatosRegistroRespuesta;
import com.forohub.forohub.model.respuesta.Respuesta;
import com.forohub.forohub.repository.RespuestaRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("respuesta")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {
    @Autowired
    private RespuestaRepository respuestaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity detalleRespuesta(@RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta, UriComponentsBuilder uriComponentsBuilder) {
        Respuesta respuestaRegistrada = respuestaRepository.save(new Respuesta(datosRegistroRespuesta));
        DatosDetalleRespuesta datosDetalleRespuesta = new DatosDetalleRespuesta(respuestaRegistrada.getId(),respuestaRegistrada.getFechaCreacion(),respuestaRegistrada.getUsuarioId());
        URI url = uriComponentsBuilder.path("/respuesta/{id}").buildAndExpand(respuestaRegistrada.getId()).toUri();
        return ResponseEntity.created(url).body(datosDetalleRespuesta);    }
}
