package com.unicauca.persistencia.infraestructura.output.persistencia.repositorios;

import com.unicauca.persistencia.infraestructura.output.persistencia.entidades.AsignaturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepository extends JpaRepository<AsignaturaEntity, Integer> {

}
