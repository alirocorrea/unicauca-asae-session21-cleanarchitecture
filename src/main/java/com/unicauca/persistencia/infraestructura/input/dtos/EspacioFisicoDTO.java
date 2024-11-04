package com.unicauca.persistencia.infraestructura.input.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EspacioFisicoDTO {
    private Integer id;
    private String nombre;
    private Integer capacidad;
}
