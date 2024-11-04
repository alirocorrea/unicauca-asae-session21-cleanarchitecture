package com.unicauca.persistencia.aplicacion.output;

import com.unicauca.persistencia.dominio.modelos.FranjaHoraria;

import java.util.List;

public interface FranjaHorariaGatewayOutputPort {
    boolean existeCursoPorId(Integer idCurso);

    boolean existeEspacioFisicoPorId(Integer idEspacioFisico);

    boolean existeDocentePorId(Integer idDocente);

    FranjaHoraria guardarFranjaHoraria(FranjaHoraria franja);

    boolean estaEspacioFisicoOcupado(FranjaHoraria franja);

    boolean estaDocenteOcupado(FranjaHoraria franja);

    List<FranjaHoraria> listarFranjaHorariaPorDocente(Integer idDocente);
}
