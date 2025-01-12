package com.forohub.forohub.model.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

public record DatosRegistroUsuario(
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String correoElectronico,
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\S+$).{8,}$",
                message = "La contraseña debe contener al menos 8 caracteres, una mayúscula, una minúscula, un número y un carácter especial.")
        String contrasena)
{
        @Override
        public String contrasena() {
                return contrasena;
        }

}
