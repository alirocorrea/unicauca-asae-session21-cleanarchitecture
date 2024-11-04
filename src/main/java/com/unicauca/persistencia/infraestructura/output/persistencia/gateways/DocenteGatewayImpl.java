package com.unicauca.persistencia.infraestructura.output.persistencia.gateways;

import com.unicauca.persistencia.aplicacion.output.DocenteGatewayOutputPort;
import com.unicauca.persistencia.dominio.modelos.Docente;
import com.unicauca.persistencia.infraestructura.output.persistencia.entidades.DocenteEntity;
import com.unicauca.persistencia.infraestructura.output.persistencia.mappers.DocenteOutputMapper;
import com.unicauca.persistencia.infraestructura.output.persistencia.repositorios.DocenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DocenteGatewayImpl implements DocenteGatewayOutputPort {

    private final DocenteRepository docenteRepository;

    @Override
    public boolean existeDocentePorCorreo(String correo) {
        return docenteRepository.existsByCorreo(correo);
    }

    @Override
    public Docente guardarDocente(Docente docente) {
        final DocenteEntity docenteEntidad = DocenteOutputMapper.mapDocenteEntity(docente);
        docenteRepository.save(docenteEntidad);
        docente.setId(docenteEntidad.getId());
        return docente;
    }
}
