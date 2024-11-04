package com.unicauca.persistencia.infraestructura.input.dtos.respuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EspacioFisicoDTORespuesta {
    private Integer id;
    private String nombre;
    private Integer capacidad;
}
