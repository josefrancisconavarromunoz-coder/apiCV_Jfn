package edu.apiCv.services;

import edu.apiCv.dtos.AlumnoRequestDto;
import edu.apiCv.dtos.AlumnoResponseDto;
import java.util.List;
import edu.apiCv.entities.TipoPerfil;

/** Define las operaciones disponibles para gestionar alumnos. */
public interface AlumnoService {
    /** Obtiene todos los registros.
     * @return lista de alumnos
     */
    List<AlumnoResponseDto> findAll();

    /** Obtiene los currículums de un tipo de perfil.
     * @param tipoPerfil tipo de perfil que se desea consultar
     * @return lista de currículums
     */
    List<AlumnoResponseDto> findAllByTipoPerfil(TipoPerfil tipoPerfil);

    /** Busca un registro por su identificador.
     * @param id identificador del registro
     * @return datos del registro
     */
    AlumnoResponseDto findById(Long id);

    /** Registra un nuevo elemento.
     * @param dto datos que se van a guardar
     * @return elemento creado
     */
    AlumnoResponseDto create(AlumnoRequestDto dto);

    /** Modifica un elemento existente.
     * @param id identificador del elemento
     * @param dto nuevos datos
     * @return elemento actualizado
     */
    AlumnoResponseDto update(Long id, AlumnoRequestDto dto);

    /** Elimina un elemento por su identificador.
     * @param id identificador del elemento
     */
    void delete(Long id);
}
