package edu.apiCv.services;

import edu.apiCv.dtos.AptitudRequestDto;
import edu.apiCv.dtos.AptitudResponseDto;
import java.util.List;

/** Define las operaciones disponibles para gestionar aptituds. */
public interface AptitudService {
    /** Obtiene todos los registros.
     * @return lista de aptituds
     */
    List<AptitudResponseDto> findAll();

    /** Busca un registro por su identificador.
     * @param id identificador del registro
     * @return datos del registro
     */
    AptitudResponseDto findById(Long id);

    /** Registra un nuevo elemento.
     * @param dto datos que se van a guardar
     * @return elemento creado
     */
    AptitudResponseDto create(AptitudRequestDto dto);

    /** Modifica un elemento existente.
     * @param id identificador del elemento
     * @param dto nuevos datos
     * @return elemento actualizado
     */
    AptitudResponseDto update(Long id, AptitudRequestDto dto);

    /** Elimina un elemento por su identificador.
     * @param id identificador del elemento
     */
    void delete(Long id);
}
