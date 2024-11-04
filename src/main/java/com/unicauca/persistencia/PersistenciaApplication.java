package com.unicauca.persistencia;

import com.unicauca.persistencia.infraestructura.output.persistencia.entidades.AsignaturaEntity;
import com.unicauca.persistencia.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import com.unicauca.persistencia.infraestructura.output.persistencia.repositorios.AsignaturaRepository;
import com.unicauca.persistencia.infraestructura.output.persistencia.repositorios.EspacioFisicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionTemplate;


@RequiredArgsConstructor
@SpringBootApplication
public class PersistenciaApplication implements CommandLineRunner {

	private final AsignaturaRepository asignaturaRepository;
	private final EspacioFisicoRepository espacioFisicoRepository;

	private final TransactionTemplate transactionTemplate;
	public static void main(String[] args) {
		SpringApplication.run(PersistenciaApplication.class, args);
	}

	@Override
	public void run(String... args) {
		preCargarDatos();
	}
	private void preCargarDatos() {
		AsignaturaEntity asignaturaEntity = new AsignaturaEntity();
		asignaturaEntity.setCodigo("A1");
		asignaturaEntity.setNombre("Asignatura 1");

		if (asignaturaRepository.findAll().isEmpty())
			asignaturaRepository.save(asignaturaEntity);

		EspacioFisicoEntity espacioFisico = new EspacioFisicoEntity();
		espacioFisico.setNombre("EspacioFisico 1");
		espacioFisico.setCapacidad(10);

		if (espacioFisicoRepository.findAll().isEmpty())
			espacioFisicoRepository.save(espacioFisico);
	}
}
