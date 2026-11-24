package edu.apiCv.services;

import edu.apiCv.dtos.ExperienciaRequestDto;
import edu.apiCv.dtos.ExperienciaResponseDto;
import java.util.List;

/** Define las operaciones disponibles para gestionar experiencias. */
public interface ExperienciaService {
    /** Obtiene todos los registros.
     * @return lista de experiencias
     */
    List<ExperienciaResponseDto> findAll();

    /** Busca un registro por su identificador.
     * @param id identificador del registro
     * @return datos del registro
     */
    ExperienciaResponseDto findById(Long id);

    /** Registra un nuevo elemento.
     * @param dto datos que se van a guardar
     * @return elemento creado
     */
    ExperienciaResponseDto create(ExperienciaRequestDto dto);

    /** Modifica un elemento existente.
     * @param id identificador del elemento
     * @param dto nuevos datos
     * @return elemento actualizado
     */
    ExperienciaResponseDto update(Long id, ExperienciaRequestDto dto);

    /** Elimina un elemento por su identificador.
     * @param id identificador del elemento
     */
    void delete(Long id);
}
