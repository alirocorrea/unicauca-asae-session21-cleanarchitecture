package com.unicauca.persistencia.infraestructura.input.controladores;

import com.unicauca.persistencia.aplicacion.input.EspacioFisicoInputPort;
import com.unicauca.persistencia.dominio.modelos.EspacioFisico;
import com.unicauca.persistencia.infraestructura.input.dtos.respuesta.EspacioFisicoDTORespuesta;
import com.unicauca.persistencia.infraestructura.input.mappers.EspacioFisicoInputMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/espacios-fisicos")
public class EspacioFisicoController {

    private final EspacioFisicoInputPort espacioFisicoInputPort;

    @GetMapping
    public ResponseEntity<List<EspacioFisicoDTORespuesta>> listarEspaciosFisicos(
            @RequestParam(defaultValue = "") final String nombre,
            @RequestParam(defaultValue = "0") final Integer capacidad
    ) {
        final List<EspacioFisico> espacioFisicos = espacioFisicoInputPort.listaEspacioFisicos(nombre, capacidad);
        return new ResponseEntity<>(EspacioFisicoInputMapper.buildListEspacioFisicoDTORespuesta(espacioFisicos), HttpStatus.OK);
    }
}


