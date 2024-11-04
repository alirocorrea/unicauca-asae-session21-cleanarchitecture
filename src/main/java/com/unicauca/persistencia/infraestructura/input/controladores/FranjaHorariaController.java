package com.unicauca.persistencia.infraestructura.input.controladores;

import com.unicauca.persistencia.aplicacion.input.FranjaHorariaInputPort;
import com.unicauca.persistencia.dominio.modelos.FranjaHoraria;
import com.unicauca.persistencia.infraestructura.input.dtos.peticion.FranjaHorariaDTOPeticion;
import com.unicauca.persistencia.infraestructura.input.dtos.respuesta.FranjaCreadaDTORespuesta;
import com.unicauca.persistencia.infraestructura.input.dtos.respuesta.FranjaHorariaDTORespuesta;
import com.unicauca.persistencia.infraestructura.input.mappers.FranjaHorariaInputMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/franjas-horarias")
public class FranjaHorariaController {

    private final FranjaHorariaInputPort franjaHorariaInputPort;

    @PostMapping
    public ResponseEntity<FranjaCreadaDTORespuesta> crearFranja(@Valid @RequestBody final FranjaHorariaDTOPeticion peticion) {
        final FranjaHoraria franjaHorariaPeticion = FranjaHorariaInputMapper.buildFranjaHoraria(peticion);
        final FranjaHoraria franjaHorariaCreada = franjaHorariaInputPort.crearFranjaHoraria(franjaHorariaPeticion);
        return new ResponseEntity<>(FranjaHorariaInputMapper.buildFranjaCreadaDTORespuesta(franjaHorariaCreada), HttpStatus.CREATED);
    }

    @GetMapping("/{idDocente}")
    public ResponseEntity<List<FranjaHorariaDTORespuesta>> listarFranjasPorDocente(@PathVariable @Min(value = 0, message = "{docente.id.min}") final Integer idDocente) {
        final List<FranjaHoraria> franjaHorarias = franjaHorariaInputPort.listarFranjasHorariaPorDocente(idDocente);
        return new ResponseEntity<>(FranjaHorariaInputMapper.buildListaFranjaHorariaDTORespuestas(franjaHorarias), HttpStatus.OK);
    }
}
