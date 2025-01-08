package com.forohub.forohub.controller;

import com.forohub.forohub.infra.security.AutenticacionService;
import com.forohub.forohub.model.usuario.DatosRegistroUsuario;
import com.forohub.forohub.model.usuario.Usuario;
import com.forohub.forohub.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    @Transactional
    public void registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario) {
        String hashedPassword = passwordEncoder.encode(datosRegistroUsuario.contrasena());
        System.out.println(hashedPassword);
        usuarioRepository.save(new Usuario(datosRegistroUsuario));
    }

}
