package com.unicauca.persistencia.infraestructura.input.dtos.respuesta;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@Builder
public class FranjaCreadaDTORespuesta {

    private Integer id;
    private String nombre;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Integer idCurso;
    private Integer idEspacioFisico;
}
