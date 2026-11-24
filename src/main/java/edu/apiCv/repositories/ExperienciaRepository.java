package edu.apiCv.repositories;

import edu.apiCv.entities.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;

/** Repositorio para acceder a las experiencias laborales. */
public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> { }
