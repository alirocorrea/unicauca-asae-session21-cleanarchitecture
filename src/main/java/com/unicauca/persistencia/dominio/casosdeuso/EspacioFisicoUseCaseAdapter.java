package com.unicauca.persistencia.dominio.casosdeuso;

import com.unicauca.persistencia.aplicacion.input.EspacioFisicoInputPort;
import com.unicauca.persistencia.aplicacion.output.EspacioFisicoGatewayOutputPort;
import com.unicauca.persistencia.dominio.modelos.EspacioFisico;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class EspacioFisicoUseCaseAdapter implements EspacioFisicoInputPort {

    private EspacioFisicoGatewayOutputPort espacioFisicoGateway;

    @Override
    public List<EspacioFisico> listaEspacioFisicos(final String nombre, final Integer capacidad) {
        return espacioFisicoGateway.listarEspacioFisicos(nombre, capacidad);
    }
}
