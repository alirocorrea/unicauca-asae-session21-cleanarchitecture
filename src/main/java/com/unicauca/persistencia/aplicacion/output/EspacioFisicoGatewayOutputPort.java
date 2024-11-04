package com.unicauca.persistencia.aplicacion.output;

import com.unicauca.persistencia.dominio.modelos.EspacioFisico;

import java.util.List;

public interface EspacioFisicoGatewayOutputPort {
    List<EspacioFisico> listarEspacioFisicos(String nombre, Integer capacidad);
}
