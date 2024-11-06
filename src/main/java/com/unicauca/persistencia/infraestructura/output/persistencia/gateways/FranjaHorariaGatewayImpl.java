package com.unicauca.persistencia.infraestructura.output.persistencia.gateways;

import com.unicauca.persistencia.aplicacion.output.FranjaHorariaGatewayOutputPort;
import com.unicauca.persistencia.dominio.modelos.FranjaHoraria;
import com.unicauca.persistencia.infraestructura.output.persistencia.entidades.CursoEntity;
import com.unicauca.persistencia.infraestructura.output.persistencia.entidades.DocenteEntity;
import com.unicauca.persistencia.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import com.unicauca.persistencia.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;
import com.unicauca.persistencia.infraestructura.output.persistencia.mappers.FranjaHorariaOutputMapper;
import com.unicauca.persistencia.infraestructura.output.persistencia.repositorios.CursoRepository;
import com.unicauca.persistencia.infraestructura.output.persistencia.repositorios.DocenteRepository;
import com.unicauca.persistencia.infraestructura.output.persistencia.repositorios.EspacioFisicoRepository;
import com.unicauca.persistencia.infraestructura.output.persistencia.repositorios.FranjaHorariaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FranjaHorariaGatewayImpl implements FranjaHorariaGatewayOutputPort {

    private final FranjaHorariaRepository franjaHorariaRepository;
    private final CursoRepository cursoRepository;
    private final EspacioFisicoRepository espacioFisicoRepository;
    private final DocenteRepository docenteRepository;

    @Override
    public boolean existeCursoPorId(final Integer idCurso) {
        return cursoRepository.existsById(idCurso);
    }

    @Override
    public boolean existeEspacioFisicoPorId(final Integer idEspacioFisico) {
        return espacioFisicoRepository.existsById(idEspacioFisico);
    }

    @Override
    public boolean existeDocentePorId(final Integer idDocente) {
        return docenteRepository.existsById(idDocente);
    }

    @Override
    public FranjaHoraria guardarFranjaHoraria(final FranjaHoraria franja) {
        CursoEntity cursoEntity = cursoRepository.getReferenceById(franja.getCurso().getId());
        EspacioFisicoEntity espacioFisicoEntity = espacioFisicoRepository.getReferenceById(franja.getEspacioFisico().getId());
        FranjaHorariaEntity franjaHorariaEntity = FranjaHorariaOutputMapper.buildFranjaHorariaEntity(franja, cursoEntity, espacioFisicoEntity);
        franjaHorariaRepository.save(franjaHorariaEntity);
        franja.setId(franjaHorariaEntity.getId());
        return franja;
    }

    @Override
    public boolean estaEspacioFisicoOcupado(final FranjaHoraria franja) {
        return espacioFisicoRepository.estaEspacioFisicoOcupado(
                franja.getEspacioFisico().getId(),
                franja.getDia().toUpperCase(),
                franja.getHoraInicio().plusMinutes(1L),
                franja.getHoraFin().minusMinutes(1L)
        );
    }

    @Override
    public boolean estaDocenteOcupado(final FranjaHoraria franja) {
        DocenteEntity docenteEntity = cursoRepository.getDocenteByIdCurso(franja.getCurso().getId());
        return docenteRepository.estaDocenteOcupado(
                docenteEntity.getId(),
                franja.getDia().toUpperCase(),
                franja.getHoraInicio().plusMinutes(1L),
                franja.getHoraFin().minusMinutes(1L)
        ) > 0;
    }

    @Override
    @Transactional
    public List<FranjaHoraria> listarFranjaHorariaPorDocente(final Integer idDocente) {
        DocenteEntity docenteEntity = docenteRepository.getReferenceById(idDocente);
        List<CursoEntity> cursosDocente = docenteEntity.getCurso().stream().toList();
        List<FranjaHorariaEntity> franjasHorariasEntities = franjaHorariaRepository.findFranjaHorariaByCursoIn(cursosDocente);
        return franjasHorariasEntities.stream().map(FranjaHorariaOutputMapper::buildFranjaHoraria).toList();
    }
}
