package com.forohub.forohub.model.topico;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        String fechaCreacion,
        String status,
        Long usuarioId,
        Long cursoId
) {

}
