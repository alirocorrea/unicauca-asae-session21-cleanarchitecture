package com.unicauca.persistencia.infraestructura.output.persistencia.repositorios;

import com.unicauca.persistencia.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalTime;
import java.util.List;

public interface EspacioFisicoRepository extends JpaRepository<EspacioFisicoEntity, Integer> {

    @Query("SELECT COUNT(f) > 0 FROM FranjaHorariaEntity f JOIN f.espacioFisico e " +
            "WHERE e.id = :idEspacioFisico AND f.dia = :dia " +
            "AND ((:horaInicio BETWEEN f.horaInicio AND f.horaFin) " +
            "OR (:horaFin BETWEEN f.horaInicio AND f.horaFin) " +
            "OR (f.horaInicio BETWEEN :horaInicio AND :horaFin) " +
            "OR (f.horaFin BETWEEN :horaInicio AND :horaFin))")
    boolean estaEspacioFisicoOcupado(@Param("idEspacioFisico") Integer idEspacioFisico,
                                   @Param("dia") String dia,
                                   @Param("horaInicio") LocalTime horaInicio,
                                   @Param("horaFin") LocalTime horaFin);

    List<EspacioFisicoEntity> findByNombreStartingWithIgnoreCaseAndCapacidadGreaterThanEqualOrderByNombreAsc(String nombre, Integer capacidad);
}
