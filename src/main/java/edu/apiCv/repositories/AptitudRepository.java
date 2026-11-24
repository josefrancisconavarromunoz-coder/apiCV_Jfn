package edu.apiCv.repositories;

import edu.apiCv.entities.Aptitud;
import org.springframework.data.jpa.repository.JpaRepository;

/** Repositorio para acceder a las aptitudes. */
public interface AptitudRepository extends JpaRepository<Aptitud, Long> { }
