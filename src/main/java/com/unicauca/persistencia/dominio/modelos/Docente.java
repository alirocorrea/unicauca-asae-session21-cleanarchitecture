package com.unicauca.persistencia.dominio.modelos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Docente {
    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;
    private Oficina oficina;
}
