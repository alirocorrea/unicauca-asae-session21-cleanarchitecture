package com.unicauca.persistencia.dominio.modelos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EspacioFisico {

    private Integer id;
    private String nombre;
    private Integer capacidad;
}
