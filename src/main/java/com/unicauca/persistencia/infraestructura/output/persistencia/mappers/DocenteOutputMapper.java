package com.unicauca.persistencia.infraestructura.output.persistencia.mappers;

import com.unicauca.persistencia.dominio.modelos.Docente;
import com.unicauca.persistencia.dominio.modelos.Oficina;
import com.unicauca.persistencia.infraestructura.output.persistencia.entidades.DocenteEntity;
import com.unicauca.persistencia.infraestructura.output.persistencia.entidades.OficinaEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DocenteOutputMapper {

    public static DocenteEntity mapDocenteEntity(final Docente docente) {
        final DocenteEntity entity = new DocenteEntity();
        entity.setNombre(docente.getNombre());
        entity.setApellido(docente.getApellido());
        entity.setCorreo(docente.getCorreo());
        entity.setOficina(mapOficinaEntity(docente.getOficina()));
        return entity;
    }

    public static OficinaEntity mapOficinaEntity(final Oficina oficina) {
        final OficinaEntity entity = new OficinaEntity();
        entity.setNombre(oficina.getNombre());
        entity.setUbicacion(oficina.getUbicacion());
        return entity;
    }
}
