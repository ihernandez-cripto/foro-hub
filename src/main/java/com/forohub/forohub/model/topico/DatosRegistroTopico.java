package com.forohub.forohub.model.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String status,
        @NotNull
        Long usuarioId,
        @NotNull
        Long cursoId
) {
}
