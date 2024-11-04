package com.unicauca.persistencia.aplicacion.input;

import com.unicauca.persistencia.dominio.modelos.FranjaHoraria;

import java.util.List;

public interface FranjaHorariaInputPort {

    FranjaHoraria crearFranjaHoraria(FranjaHoraria franjaHoraria);

    List<FranjaHoraria> listarFranjasHorariaPorDocente(Integer idDocente);
}
