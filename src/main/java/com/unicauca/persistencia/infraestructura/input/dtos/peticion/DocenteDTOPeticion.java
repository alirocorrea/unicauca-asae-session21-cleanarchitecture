package com.unicauca.persistencia.infraestructura.input.dtos.peticion;

import com.unicauca.persistencia.infraestructura.input.dtos.OficinaDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class DocenteDTOPeticion {

    @NotBlank(message = "{docente.nombre.blank}")
    private String nombre;

    private String apellido;

    @NotBlank(message = "{docente.correo.blank}")
    private String correo;

    @Valid
    @NotNull(message = "{docente.oficina.null}")
    private OficinaDTO oficina;
}
