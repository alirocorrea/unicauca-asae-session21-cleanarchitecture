package com.unicauca.persistencia.infraestructura.output.controladorexcepciones.excepciones;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReglaNegocioException extends RuntimeException {

    private final String codigo;

    public ReglaNegocioException(final String mensaje) {
        super(mensaje);
        this.codigo = getClass().getSimpleName();
    }
}
