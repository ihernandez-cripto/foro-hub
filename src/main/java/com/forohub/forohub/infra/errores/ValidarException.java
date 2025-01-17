package com.forohub.forohub.infra.errores;

public class ValidarException extends RuntimeException {
    public ValidarException(String mensaje) {
        super(mensaje);
    }
}
