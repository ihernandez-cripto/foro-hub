package com.forohub.forohub.controller;

import com.forohub.forohub.model.curso.Curso;
import com.forohub.forohub.model.curso.DatosRegistroCurso;
import com.forohub.forohub.repository.CursoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("curso")
@SecurityRequirement(name = "bearer-key")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public void registrarCurso(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso) {
        cursoRepository.save(new Curso(datosRegistroCurso));
    }

}
