package com.unicauca.persistencia.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Oficina {

    private String nombre;
    private String ubicacion;
}
