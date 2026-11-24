package edu.apiCv.repositories;

import edu.apiCv.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.apiCv.entities.TipoPerfil;
import java.util.List;
import java.util.Optional;

/** Repositorio para acceder a los alumnos almacenados. */
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    /** Busca perfiles por tipo.
     * @param tipoPerfil tipo de perfil que se desea consultar
     * @return perfiles del tipo indicado
     */
    List<Alumno> findByTipoPerfil(TipoPerfil tipoPerfil);

    /** Busca un perfil por identificador y tipo.
     * @param id identificador del perfil
     * @param tipoPerfil tipo de perfil
     * @return perfil encontrado, si existe
     */
    Optional<Alumno> findByIdAndTipoPerfil(Long id, TipoPerfil tipoPerfil);
}
