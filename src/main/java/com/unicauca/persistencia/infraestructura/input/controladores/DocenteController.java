package com.unicauca.persistencia.infraestructura.input.controladores;

import com.unicauca.persistencia.aplicacion.input.DocenteInputPort;
import com.unicauca.persistencia.dominio.modelos.Docente;
import com.unicauca.persistencia.infraestructura.input.dtos.peticion.DocenteDTOPeticion;
import com.unicauca.persistencia.infraestructura.input.dtos.respuesta.DocenteDTORespuesta;
import com.unicauca.persistencia.infraestructura.input.mappers.DocenteInputMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    private final DocenteInputPort docenteInputPort;

    @PostMapping
    public ResponseEntity<DocenteDTORespuesta> crearDocente(@Valid @RequestBody final DocenteDTOPeticion peticion) {
        final Docente docentePeticion = DocenteInputMapper.buildDocente(peticion);
        final Docente docenteCreado = docenteInputPort.crearDocente(docentePeticion);
        return new ResponseEntity<>(DocenteInputMapper.buildDocenteDTORespuesta(docenteCreado), HttpStatus.CREATED);
    }
}
