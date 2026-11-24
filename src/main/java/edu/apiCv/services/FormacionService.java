package edu.apiCv.services;

import edu.apiCv.dtos.FormacionRequestDto;
import edu.apiCv.dtos.FormacionResponseDto;
import java.util.List;

/** Define las operaciones disponibles para gestionar formacions. */
public interface FormacionService {
    /** Obtiene todos los registros.
     * @return lista de formacions
     */
    List<FormacionResponseDto> findAll();

    /** Busca un registro por su identificador.
     * @param id identificador del registro
     * @return datos del registro
     */
    FormacionResponseDto findById(Long id);

    /** Registra un nuevo elemento.
     * @param dto datos que se van a guardar
     * @return elemento creado
     */
    FormacionResponseDto create(FormacionRequestDto dto);

    /** Modifica un elemento existente.
     * @param id identificador del elemento
     * @param dto nuevos datos
     * @return elemento actualizado
     */
    FormacionResponseDto update(Long id, FormacionRequestDto dto);

    /** Elimina un elemento por su identificador.
     * @param id identificador del elemento
     */
    void delete(Long id);
}
