package com.unicauca.persistencia.infraestructura.input.dtos.respuesta;

import com.unicauca.persistencia.infraestructura.input.dtos.OficinaDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DocenteDTORespuesta {
    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;
    private OficinaDTO oficina;
}
