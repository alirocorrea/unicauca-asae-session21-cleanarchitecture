package com.unicauca.persistencia.infraestructura.output.controladorexcepciones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDTORespuesta {
    private String codigo;
    private String mensaje;
    private String metodo;
    private String url;
}
