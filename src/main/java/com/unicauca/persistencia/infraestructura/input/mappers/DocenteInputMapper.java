package com.unicauca.persistencia.infraestructura.input.mappers;

import com.unicauca.persistencia.dominio.modelos.Docente;
import com.unicauca.persistencia.dominio.modelos.Oficina;
import com.unicauca.persistencia.infraestructura.input.dtos.OficinaDTO;
import com.unicauca.persistencia.infraestructura.input.dtos.peticion.DocenteDTOPeticion;
import com.unicauca.persistencia.infraestructura.input.dtos.respuesta.DocenteDTORespuesta;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DocenteInputMapper {

    public static Docente buildDocente(final DocenteDTOPeticion peticion) {
        return Docente.builder()
                .nombre(peticion.getNombre())
                .apellido(peticion.getApellido())
                .correo(peticion.getCorreo())
                .oficina(new Oficina(peticion.getOficina().getNombre(), peticion.getOficina().getUbicacion()))
                .build();
    }

    public static DocenteDTORespuesta buildDocenteDTORespuesta(final Docente docente) {
        return DocenteDTORespuesta.builder()
                .id(docente.getId())
                .nombre(docente.getNombre())
                .apellido(docente.getApellido())
                .oficina(buildOficinaDTO(docente))
                .build();
    }

    private static OficinaDTO buildOficinaDTO(Docente docente) {
        return new OficinaDTO(
                docente.getOficina().getNombre(),
                docente.getOficina().getUbicacion()
        );
    }
}
