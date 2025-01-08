package com.forohub.forohub.controller;

import com.auth0.jwt.JWT;
import com.forohub.forohub.infra.security.DatosJWTtoken;
import com.forohub.forohub.infra.security.TokenService;
import com.forohub.forohub.model.usuario.DatosLogin;
import com.forohub.forohub.model.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticacionUsuario(@RequestBody @Valid DatosLogin datosLogin) {

        Authentication authtoken = new UsernamePasswordAuthenticationToken(datosLogin.correoElectronico(),datosLogin.contrasena());
        var usuarioAutenticado = authenticationManager.authenticate(authtoken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTtoken(JWTtoken));

    }
}
