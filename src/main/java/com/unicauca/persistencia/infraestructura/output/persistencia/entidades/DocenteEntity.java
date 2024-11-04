package com.unicauca.persistencia.infraestructura.output.persistencia.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "docente")
@PrimaryKeyJoinColumn(name = "id_persona")
public class DocenteEntity extends PersonaEntity {

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private OficinaEntity oficina;

    @ManyToMany(mappedBy = "docente",cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<CursoEntity> curso;
}
