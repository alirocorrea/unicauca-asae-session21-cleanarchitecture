package com.unicauca.persistencia.infraestructura.input.mappers;

import com.unicauca.persistencia.dominio.modelos.EspacioFisico;
import com.unicauca.persistencia.infraestructura.input.dtos.respuesta.EspacioFisicoDTORespuesta;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EspacioFisicoInputMapper {

    public static List<EspacioFisicoDTORespuesta> buildListEspacioFisicoDTORespuesta(final List<EspacioFisico> espacioFisicos) {
        return espacioFisicos.stream().map(EspacioFisicoInputMapper::buildEspacioFisicoDTORespuesta).toList();
    }

    public static EspacioFisicoDTORespuesta buildEspacioFisicoDTORespuesta(EspacioFisico espacioFisico) {
        return new EspacioFisicoDTORespuesta(espacioFisico.getId(), espacioFisico.getNombre(), espacioFisico.getCapacidad());
    }
}
