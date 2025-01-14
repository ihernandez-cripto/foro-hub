package com.forohub.forohub.model.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuesta(
        @NotBlank
        String mensaje,
        @NotBlank
        String solucion,
        @NotNull
        Long usuarioId,
        @NotNull
        Long topicoId)
{
}
