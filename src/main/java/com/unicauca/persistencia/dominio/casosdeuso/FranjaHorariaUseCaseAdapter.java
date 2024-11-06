package com.unicauca.persistencia.dominio.casosdeuso;

import com.unicauca.persistencia.aplicacion.input.FranjaHorariaInputPort;
import com.unicauca.persistencia.aplicacion.output.FormateadorRespuestaOutputPort;
import com.unicauca.persistencia.aplicacion.output.FranjaHorariaGatewayOutputPort;
import com.unicauca.persistencia.dominio.modelos.FranjaHoraria;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class FranjaHorariaUseCaseAdapter implements FranjaHorariaInputPort {

    private FranjaHorariaGatewayOutputPort franjaHorariaGateway;
    private FormateadorRespuestaOutputPort formateadorRespuesta;

    @Override
    public FranjaHoraria crearFranjaHoraria(final FranjaHoraria franjaHoraria) {
        if (!franjaHorariaGateway.existeCursoPorId(franjaHoraria.getCurso().getId())) {
            formateadorRespuesta.responderEntidadNoEncontradaException("Curso no encontrado");
        }
        if (!franjaHorariaGateway.existeEspacioFisicoPorId(franjaHoraria.getEspacioFisico().getId())) {
            formateadorRespuesta.responderEntidadNoEncontradaException("Espacio fisico no encontrado");
        }

        if (franjaHorariaGateway.estaEspacioFisicoOcupado(franjaHoraria)) {
            formateadorRespuesta.responderReglaNegocioException("Espacio fisico ocupado en este horario");
        }

        if (franjaHorariaGateway.estaDocenteOcupado(franjaHoraria)) {
            formateadorRespuesta.responderReglaNegocioException("Docente ocupado en este horario");
        }

        return franjaHorariaGateway.guardarFranjaHoraria(franjaHoraria);
    }

    @Override
    public List<FranjaHoraria> listarFranjasHorariaPorDocente(final Integer idDocente) {
        if (!franjaHorariaGateway.existeDocentePorId(idDocente)) {
            formateadorRespuesta.responderEntidadNoEncontradaException("Docente no encontrado");
        }
        return franjaHorariaGateway.listarFranjaHorariaPorDocente(idDocente);
    }
}
