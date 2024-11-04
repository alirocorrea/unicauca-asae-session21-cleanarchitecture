package com.unicauca.persistencia.aplicacion.input;

import com.unicauca.persistencia.dominio.modelos.EspacioFisico;

import java.util.List;

public interface EspacioFisicoInputPort {
    List<EspacioFisico> listaEspacioFisicos(String nombre, Integer capacidad);
}
