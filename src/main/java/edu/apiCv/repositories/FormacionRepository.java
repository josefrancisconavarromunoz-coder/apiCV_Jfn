package edu.apiCv.repositories;

import edu.apiCv.entities.Formacion;
import org.springframework.data.jpa.repository.JpaRepository;

/** Repositorio para acceder a las formaciones académicas. */
public interface FormacionRepository extends JpaRepository<Formacion, Long> { }
