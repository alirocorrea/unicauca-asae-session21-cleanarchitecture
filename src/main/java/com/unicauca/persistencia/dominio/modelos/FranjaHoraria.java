package com.unicauca.persistencia.dominio.modelos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Data
@Builder
public class FranjaHoraria {

    private Integer id;
    private String nombre;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Curso curso;
    private EspacioFisico espacioFisico;
}
