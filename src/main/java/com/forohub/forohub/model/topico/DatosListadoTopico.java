package com.forohub.forohub.model.topico;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        String fechaCreacion,
        String status)
 {

    public DatosListadoTopico(Topico topico) {
        this(topico.getId(),topico.getTitulo(),
            topico.getMensaje(),
            topico.getFechaCreacion(),
            topico.getStatus());
    }
}
