package com.unicauca.persistencia.infraestructura.input.dtos.peticion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Builder
public class FranjaHorariaDTOPeticion {

    @NotBlank(message = "{franja.nombre.blank}")
    private String nombre;

    @NotBlank(message = "{franja.dia.blank}")
    private String dia;

    @NotNull(message = "{franja.horaInicio.null}")
    private LocalTime horaInicio;

    @NotNull(message = "{franja.horaFin.null}")
    private LocalTime horaFin;

    @NotNull(message = "{franja.idCurso.null}")
    private Integer idCurso;

    @NotNull(message = "{franja.idEspacio.null}")
    private Integer idEspacioFisico;
}

