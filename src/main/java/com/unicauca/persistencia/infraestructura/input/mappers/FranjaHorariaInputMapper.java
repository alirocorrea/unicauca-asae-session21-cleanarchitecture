package com.unicauca.persistencia.infraestructura.input.mappers;

import com.unicauca.persistencia.dominio.modelos.Curso;
import com.unicauca.persistencia.dominio.modelos.EspacioFisico;
import com.unicauca.persistencia.dominio.modelos.FranjaHoraria;
import com.unicauca.persistencia.infraestructura.input.dtos.CursoDTO;
import com.unicauca.persistencia.infraestructura.input.dtos.EspacioFisicoDTO;
import com.unicauca.persistencia.infraestructura.input.dtos.peticion.FranjaHorariaDTOPeticion;
import com.unicauca.persistencia.infraestructura.input.dtos.respuesta.FranjaCreadaDTORespuesta;
import com.unicauca.persistencia.infraestructura.input.dtos.respuesta.FranjaHorariaDTORespuesta;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FranjaHorariaInputMapper {

    public static FranjaHoraria buildFranjaHoraria(final FranjaHorariaDTOPeticion peticion) {
        return FranjaHoraria.builder()
                .nombre(peticion.getNombre())
                .dia(peticion.getDia())
                .horaInicio(peticion.getHoraInicio())
                .horaFin(peticion.getHoraFin())
                .curso(Curso.builder().id(peticion.getIdCurso()).build())
                .espacioFisico(EspacioFisico.builder().id(peticion.getIdEspacioFisico()).build())
                .build();
    }

    public static FranjaCreadaDTORespuesta buildFranjaCreadaDTORespuesta(final FranjaHoraria franjaHoraria) {
        return FranjaCreadaDTORespuesta.builder()
                .id(franjaHoraria.getId())
                .nombre(franjaHoraria.getNombre())
                .dia(franjaHoraria.getDia())
                .horaInicio(franjaHoraria.getHoraInicio())
                .horaFin(franjaHoraria.getHoraFin())
                .idCurso(franjaHoraria.getCurso().getId())
                .idEspacioFisico(franjaHoraria.getEspacioFisico().getId())
                .build();
    }

    public static List<FranjaHorariaDTORespuesta> buildListaFranjaHorariaDTORespuestas(final List<FranjaHoraria> franjaHorarias) {
        return franjaHorarias.stream().map(FranjaHorariaInputMapper::buildFranjaHorariaDTORespuesta).toList();
    }

    public static FranjaHorariaDTORespuesta buildFranjaHorariaDTORespuesta(final FranjaHoraria franjaHoraria) {
        return FranjaHorariaDTORespuesta.builder()
                .id(franjaHoraria.getId())
                .nombre(franjaHoraria.getNombre())
                .dia(franjaHoraria.getDia())
                .horaInicio(franjaHoraria.getHoraInicio())
                .horaFin(franjaHoraria.getHoraFin())
                .curso(buildCursoDTO(franjaHoraria.getCurso()))
                .espacioFisico(buildEspacioFisicoDTO(franjaHoraria.getEspacioFisico()))
                .build();
    }

    private static EspacioFisicoDTO buildEspacioFisicoDTO(EspacioFisico espacioFisico) {
        return new EspacioFisicoDTO(espacioFisico.getId(), espacioFisico.getNombre(), espacioFisico.getCapacidad());
    }

    private static CursoDTO buildCursoDTO(Curso curso) {
        return new CursoDTO(curso.getId(), curso.getNombre());
    }
}
