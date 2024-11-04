package com.unicauca.persistencia.infraestructura.input.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OficinaDTO {
    @NotBlank(message = "{oficina.nombre.blank}")
    private String nombre;
    @NotBlank(message = "{oficina.ubicacion.blank}")
    private String ubicacion;
}
