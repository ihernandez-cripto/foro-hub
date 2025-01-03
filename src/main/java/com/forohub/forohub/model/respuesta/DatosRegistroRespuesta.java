package com.forohub.forohub.model.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuesta(
        @NotBlank
        String mensaje,
        @NotNull
        Long usuarioId,
        @NotBlank
        String respuesta
) {
}
