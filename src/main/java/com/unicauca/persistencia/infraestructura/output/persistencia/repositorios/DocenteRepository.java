package com.unicauca.persistencia.infraestructura.output.persistencia.repositorios;

import com.unicauca.persistencia.infraestructura.output.persistencia.entidades.DocenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalTime;

public interface DocenteRepository extends JpaRepository<DocenteEntity, Integer> {

    boolean existsByCorreo(String correo);

    @Query(value = "SELECT CASE WHEN COUNT(1) > 0 THEN 1 ELSE 0 END " +
            "FROM franja_horaria f " +
            "JOIN curso c ON f.curso_id = c.id " +
            "JOIN curso_docente cd ON c.id = cd.curso_id " +
            "WHERE cd.docente_id_persona = :idDocente " +
            "AND f.dia = :dia " +
            "AND ((:horaInicio BETWEEN f.hora_inicio AND f.hora_fin) " +
            "OR (:horaFin BETWEEN f.hora_inicio AND f.hora_fin) " +
            "OR (f.hora_inicio BETWEEN :horaInicio AND :horaFin) " +
            "OR (f.hora_fin BETWEEN :horaInicio AND :horaFin)) ", nativeQuery = true)
    int estaDocenteOcupado(@Param("idDocente") Integer idDocente,
                               @Param("dia") String dia,
                               @Param("horaInicio") LocalTime horaInicio,
                               @Param("horaFin") LocalTime horaFin);
}
