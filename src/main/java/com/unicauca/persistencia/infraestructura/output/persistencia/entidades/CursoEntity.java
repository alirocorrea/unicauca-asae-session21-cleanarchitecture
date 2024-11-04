package com.unicauca.persistencia.infraestructura.output.persistencia.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "curso")
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255)
    private String nombre;

    @ManyToOne()
    @JoinColumn
    private AsignaturaEntity asignatura;

    @ManyToMany()
    private Set<DocenteEntity> docente = new HashSet<>();

    @OneToMany(mappedBy = "curso", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<FranjaHorariaEntity> franjaHoraria = new HashSet<>();
}
