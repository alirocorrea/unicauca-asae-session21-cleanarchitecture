package com.unicauca.persistencia.infraestructura.input.dtos.peticion;

import com.unicauca.persistencia.infraestructura.input.dtos.OficinaDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class DocenteDTOPeticion {

    @NotBlank(message = "{docente.nombre.blank}")
    @Size(max = 255, message = "{docente.nombre.size}")
    private String nombre;

    private String apellido;

    @NotBlank(message = "{docente.correo.blank}")
    @Email(message = "{docente.correo.email}")
    private String correo;

    @Valid
    @NotNull(message = "{docente.oficina.null}")
    private OficinaDTO oficina;
}
