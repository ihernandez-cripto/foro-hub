package com.forohub.forohub.infra.security;

import com.forohub.forohub.model.usuario.DatosRegistroUsuario;
import com.forohub.forohub.model.usuario.Usuario;
import com.forohub.forohub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Usuario crearUsuario(DatosRegistroUsuario datosRegistroUsuario) {
        String hashedPassword = passwordEncoder.encode(datosRegistroUsuario.contrasena());
        Usuario usuario = new Usuario(datosRegistroUsuario.nombre(), datosRegistroUsuario.correoElectronico(),
                hashedPassword);
        return usuarioRepository.save(usuario);
    }
}
