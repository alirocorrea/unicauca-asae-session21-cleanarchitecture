package com.unicauca.persistencia.infraestructura.input.dtos.respuesta;

import com.unicauca.persistencia.infraestructura.input.dtos.CursoDTO;
import com.unicauca.persistencia.infraestructura.input.dtos.EspacioFisicoDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Data
@Builder
public class FranjaHorariaDTORespuesta {

    private Integer id;
    private String nombre;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private CursoDTO curso;
    private EspacioFisicoDTO espacioFisico;
}
