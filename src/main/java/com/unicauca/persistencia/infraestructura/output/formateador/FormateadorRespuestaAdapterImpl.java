package com.unicauca.persistencia.infraestructura.output.formateador;

import com.unicauca.persistencia.aplicacion.output.FormateadorRespuestaOutputPort;
import com.unicauca.persistencia.infraestructura.output.controladorexcepciones.excepciones.EntidadNoEncontradaException;
import com.unicauca.persistencia.infraestructura.output.controladorexcepciones.excepciones.ReglaNegocioException;
import org.springframework.stereotype.Service;

@Service
public class FormateadorRespuestaAdapterImpl implements FormateadorRespuestaOutputPort {

    @Override
    public void responderReglaNegocioException(final String mensaje) {
        throw new ReglaNegocioException(mensaje);
    }

    @Override
    public void responderEntidadNoEncontradaException(final String mensaje) {
        throw new EntidadNoEncontradaException(mensaje);
    }
}
