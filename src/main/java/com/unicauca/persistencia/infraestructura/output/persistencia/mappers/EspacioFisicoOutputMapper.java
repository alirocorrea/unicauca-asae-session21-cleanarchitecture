package com.unicauca.persistencia.infraestructura.output.persistencia.mappers;

import com.unicauca.persistencia.dominio.modelos.EspacioFisico;
import com.unicauca.persistencia.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EspacioFisicoOutputMapper {

    public static EspacioFisico buildEspacioFisico(final EspacioFisicoEntity espacioFisicoEntity) {
        return EspacioFisico.builder()
                .id(espacioFisicoEntity.getId())
                .capacidad(espacioFisicoEntity.getCapacidad())
                .nombre(espacioFisicoEntity.getNombre())
                .build();
    }
}
