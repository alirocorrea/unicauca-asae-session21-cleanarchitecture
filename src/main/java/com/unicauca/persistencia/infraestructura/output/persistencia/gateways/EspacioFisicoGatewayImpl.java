package com.unicauca.persistencia.infraestructura.output.persistencia.gateways;

import com.unicauca.persistencia.aplicacion.output.EspacioFisicoGatewayOutputPort;
import com.unicauca.persistencia.dominio.modelos.EspacioFisico;
import com.unicauca.persistencia.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import com.unicauca.persistencia.infraestructura.output.persistencia.mappers.EspacioFisicoOutputMapper;
import com.unicauca.persistencia.infraestructura.output.persistencia.repositorios.EspacioFisicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EspacioFisicoGatewayImpl implements EspacioFisicoGatewayOutputPort {

    private final EspacioFisicoRepository espacioFisicoRepository;

    @Override
    public List<EspacioFisico> listarEspacioFisicos(final String nombre, final Integer capacidad) {
        final List<EspacioFisicoEntity> espacioFisicoEntities = espacioFisicoRepository.findByNombreStartingWithIgnoreCaseAndCapacidadGreaterThanEqualOrderByNombreAsc(nombre, capacidad);
        return espacioFisicoEntities.stream().map(EspacioFisicoOutputMapper::buildEspacioFisico).toList();
    }

}
