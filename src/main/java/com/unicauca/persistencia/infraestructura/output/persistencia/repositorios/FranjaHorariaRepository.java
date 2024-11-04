package com.unicauca.persistencia.infraestructura.output.persistencia.repositorios;

import com.unicauca.persistencia.infraestructura.output.persistencia.entidades.CursoEntity;
import com.unicauca.persistencia.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FranjaHorariaRepository extends JpaRepository<FranjaHorariaEntity, Integer> {

    List<FranjaHorariaEntity> findFranjaHorariaByCursoIn(List<CursoEntity> cursos);
}
