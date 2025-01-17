package com.forohub.forohub.infra.rules;

import com.forohub.forohub.infra.errores.ValidarException;
import com.forohub.forohub.model.curso.Curso;
import com.forohub.forohub.model.topico.DatosActualizarTopico;
import com.forohub.forohub.model.topico.DatosRegistroTopico;
import com.forohub.forohub.model.topico.DatosRespuestaTopico;
import com.forohub.forohub.model.topico.Topico;
import com.forohub.forohub.model.usuario.Usuario;
import com.forohub.forohub.repository.CursoRepository;
import com.forohub.forohub.repository.TopicoRepository;
import com.forohub.forohub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class TopicoService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    Usuario usuario;

    @Autowired
    private CursoRepository cursoRepository;
    Curso curso;

    @Autowired
    private TopicoRepository topicoRepository;

    public Topico registrarTopico(DatosRegistroTopico datosRegistroTopico) {
        Usuario usuario = obtenerUsuario(datosRegistroTopico.usuarioId());
        Curso curso = obtenerCurso(datosRegistroTopico.cursoId());
        var topico = new Topico(null,datosRegistroTopico.titulo(),datosRegistroTopico.mensaje(),null,
                datosRegistroTopico.status(),usuario.getId(),curso.getId());
        topicoRepository.save(topico);
        return topico;
    }

    public ResponseEntity detalleTopico(Topico topicoRegistrado, UriComponentsBuilder uriComponentsBuilder) {
        Usuario usuario = obtenerUsuario(topicoRegistrado.getUsuarioId());
        Curso curso = obtenerCurso(topicoRegistrado.getCursoId());
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topicoRegistrado.getId(),topicoRegistrado.getTitulo(),topicoRegistrado.getMensaje(),
                topicoRegistrado.getFechaCreacion(),topicoRegistrado.getStatus(),usuario.getNombre(),curso.getNombre());
        URI url = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(topicoRegistrado.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    public ResponseEntity modificaTopico(DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        Usuario usuario = obtenerUsuario(topico.getUsuarioId());
        Curso curso = obtenerCurso(topico.getCursoId());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion(),
                topico.getStatus(),usuario.getNombre(),curso.getNombre()));
    }

    public ResponseEntity consultaTopico(Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        Usuario usuario = obtenerUsuario(topico.getUsuarioId());
        Curso curso = obtenerCurso(topico.getCursoId());
        var datosTopico = new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion(),
                topico.getStatus(),usuario.getNombre(),curso.getNombre());
        return ResponseEntity.ok(datosTopico);
    }

    private Usuario obtenerUsuario(Long usuarioId) {
        return usuarioRepository.findById(usuarioId).orElseThrow(() -> new ValidarException("No existe un usuario con el id informado"));

    }

    private Curso obtenerCurso(Long cursoId) {
        return cursoRepository.findById(cursoId).orElseThrow(() -> new ValidarException("No existe un curso con el id informado"));

    }

}
