package com.unicauca.persistencia.dominio.casosdeuso;

import com.unicauca.persistencia.aplicacion.input.DocenteInputPort;
import com.unicauca.persistencia.aplicacion.output.DocenteGatewayOutputPort;
import com.unicauca.persistencia.aplicacion.output.FormateadorRespuestaOutputPort;
import com.unicauca.persistencia.dominio.modelos.Docente;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocenteUseCaseAdapter implements DocenteInputPort {

    private DocenteGatewayOutputPort docenteGateway;
    private FormateadorRespuestaOutputPort formateadorRespuesta;

    @Override
    public Docente crearDocente(final Docente docente) {
        if (docenteGateway.existeDocentePorCorreo(docente.getCorreo())) {
            formateadorRespuesta.responderReglaNegocioException("Correo ya existente");
        }
        return docenteGateway.guardarDocente(docente);
    }
}
