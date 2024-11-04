package com.unicauca.persistencia.infraestructura.output.persistencia.mappers;

import com.unicauca.persistencia.dominio.modelos.Curso;
import com.unicauca.persistencia.dominio.modelos.EspacioFisico;
import com.unicauca.persistencia.dominio.modelos.FranjaHoraria;
import com.unicauca.persistencia.infraestructura.output.persistencia.entidades.CursoEntity;
import com.unicauca.persistencia.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import com.unicauca.persistencia.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FranjaHorariaOutputMapper {

    public static FranjaHorariaEntity buildFranjaHorariaEntity(FranjaHoraria franjaHoraria, CursoEntity cursoEntity, EspacioFisicoEntity espacioFisicoEntity) {
        FranjaHorariaEntity franjaHorariaEntity = new FranjaHorariaEntity();
        franjaHorariaEntity.setNombre(franjaHoraria.getNombre());
        franjaHorariaEntity.setDia(franjaHoraria.getDia());
        franjaHorariaEntity.setHoraInicio(franjaHoraria.getHoraInicio());
        franjaHorariaEntity.setHoraFin(franjaHoraria.getHoraFin());
        franjaHorariaEntity.setCurso(cursoEntity);
        franjaHorariaEntity.setEspacioFisico(espacioFisicoEntity);
        return franjaHorariaEntity;
    }

    public static FranjaHoraria buildFranjaHoraria(FranjaHorariaEntity franjaHorariaEntity) {
        CursoEntity cursoEntity = franjaHorariaEntity.getCurso();
        EspacioFisicoEntity espacioFisicoEntity = franjaHorariaEntity.getEspacioFisico();
        return FranjaHoraria.builder()
                .id(franjaHorariaEntity.getId())
                .nombre(franjaHorariaEntity.getNombre())
                .dia(franjaHorariaEntity.getDia())
                .horaInicio(franjaHorariaEntity.getHoraInicio())
                .horaFin(franjaHorariaEntity.getHoraFin())
                .curso(buildCurso(cursoEntity))
                .espacioFisico(buildEspacioFisico(espacioFisicoEntity))
                .build();
    }

    private static EspacioFisico buildEspacioFisico(EspacioFisicoEntity espacioFisicoEntity) {
        return EspacioFisico.builder()
                .id(espacioFisicoEntity.getId())
                .nombre(espacioFisicoEntity.getNombre())
                .capacidad(espacioFisicoEntity.getCapacidad())
                .build();
    }

    private static Curso buildCurso(CursoEntity cursoEntity) {
        return Curso.builder()
                .id(cursoEntity.getId())
                .nombre(cursoEntity.getNombre())
                .build();
    }
}
