package com.unicauca.persistencia.infraestructura.output.persistencia.repositorios;

import com.unicauca.persistencia.infraestructura.output.persistencia.entidades.CursoEntity;
import com.unicauca.persistencia.infraestructura.output.persistencia.entidades.DocenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CursoRepository extends JpaRepository<CursoEntity, Integer> {

    @Query("SELECT d FROM CursoEntity c JOIN c.docente d WHERE c.id = ?1")
    DocenteEntity getDocenteByIdCurso(Integer idCurso);
}
