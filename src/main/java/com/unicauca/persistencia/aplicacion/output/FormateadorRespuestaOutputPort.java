package com.unicauca.persistencia.aplicacion.output;

public interface FormateadorRespuestaOutputPort {
    void responderReglaNegocioException(String mensaje);

    void responderEntidadNoEncontradaException(String mensaje);
}
