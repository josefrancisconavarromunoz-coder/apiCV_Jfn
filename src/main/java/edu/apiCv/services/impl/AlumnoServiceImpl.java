
package edu.apiCv.services.impl;

import edu.apiCv.dtos.AlumnoRequestDto;
import edu.apiCv.dtos.AlumnoResponseDto;
import edu.apiCv.entities.Alumno;
import edu.apiCv.entities.TipoPerfil;
import edu.apiCv.exceptions.RecursoNotFoundException;
import edu.apiCv.repositories.AlumnoRepository;
import edu.apiCv.services.AlumnoService;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementa la lógica de gestión de alumnos.
 */
@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository repository;

    /**
     * Construye el servicio con el repositorio de alumnos.
     *
     * @param repository repositorio de alumnos
     */
    public AlumnoServiceImpl(AlumnoRepository repository) {
        this.repository = repository;
    }

    /**
     * Obtiene todos los alumnos registrados.
     *
     * @return lista de alumnos
     */
    @Override
    public List<AlumnoResponseDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    /**
     * Obtiene todos los alumnos de un tipo de perfil determinado.
     *
     */
    @Override
    public List<AlumnoResponseDto> findAllByTipoPerfil(TipoPerfil tipoPerfil) {
        return repository.findByTipoPerfil(tipoPerfil)
                .stream()
                .map(this::toDto)
                .toList();
    }

    /**
     * Busca un alumno por su identificador.
     *
     */
    @Override
    public AlumnoResponseDto findById(Long id) {
        Alumno alumno = repository.findById(id)
                .orElseThrow(() -> new RecursoNotFoundException(
                        "No existe alumno con ID: " + id));

        return toDto(alumno);
    }

    /**
     * Registra un nuevo alumno.
     *
     * @param dto datos del alumno que se va a registrar
     * @return datos del alumno creado
     */
    @Override
    public AlumnoResponseDto create(AlumnoRequestDto dto) {
        return toDto(repository.save(toEntity(dto)));
    }

    /**
     * Modifica los datos de un alumno existente.
     */
    @Override
    public AlumnoResponseDto update(Long id, AlumnoRequestDto dto) {
        Alumno alumno = repository.findById(id)
                .orElseThrow(() -> new RecursoNotFoundException(
                        "No existe alumno con ID: " + id));

        copy(alumno, dto);

        return toDto(repository.save(alumno));
    }

    /**
     * Elimina un alumno por su identificador.
     *
     */
    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RecursoNotFoundException(
                    "No existe alumno con ID: " + id);
        }

        repository.deleteById(id);
    }

    /**
     * Convierte los datos de un DTO en una entidad Alumno.
     *
     * @param dto datos recibidos
     * @return entidad Alumno
     */
    private Alumno toEntity(AlumnoRequestDto dto) {
        Alumno alumno = new Alumno();

        alumno.setTipoPerfil(dto.tipoPerfil() == null
                ? TipoPerfil.ALUMNO : dto.tipoPerfil());

        alumno.setNombre(dto.nombre());
        alumno.setApellidos(dto.apellidos());
        alumno.setNif(dto.nif());
        alumno.setTelefono(dto.telefono());
        alumno.setCorreo(dto.correo());
        alumno.setDireccion(dto.direccion());
        alumno.setFechaNacimiento(dto.fechaNacimiento());
        alumno.setSobreMi(dto.sobreMi());
        alumno.setCarnetConducir(dto.carnetConducir());
        alumno.setVehiculoPropio(dto.vehiculoPropio());
        alumno.setMasInformacion(dto.masInformacion());

        return alumno;
    }

    /**
     * Convierte una entidad Alumno en un DTO de respuesta.
     *
     * @param alumno entidad que se va a convertir
     * @return dto con los datos del alumno
     */
    private AlumnoResponseDto toDto(Alumno alumno) {
        return new AlumnoResponseDto(
                alumno.getId(),
                alumno.getTipoPerfil(),
                alumno.getNombre(),
                alumno.getApellidos(),
                alumno.getNif(),
                alumno.getTelefono(),
                alumno.getCorreo(),
                alumno.getDireccion(),
                alumno.getFechaNacimiento(),
                alumno.getSobreMi(),
                alumno.getCarnetConducir(),
                alumno.getVehiculoPropio(),
                alumno.getMasInformacion()
        );
    }

    /**
     * Copia los datos del DTO sobre una entidad existente.
     *
     * @param alumno entidad que se va a modificar
     * @param dto nuevos datos
     */
    private void copy(Alumno alumno, AlumnoRequestDto dto) {
        if (dto.tipoPerfil() != null) {
            alumno.setTipoPerfil(dto.tipoPerfil());
        }

        alumno.setNombre(dto.nombre());
        alumno.setApellidos(dto.apellidos());
        alumno.setNif(dto.nif());
        alumno.setTelefono(dto.telefono());
        alumno.setCorreo(dto.correo());
        alumno.setDireccion(dto.direccion());
        alumno.setFechaNacimiento(dto.fechaNacimiento());
        alumno.setSobreMi(dto.sobreMi());
        alumno.setCarnetConducir(dto.carnetConducir());
        alumno.setVehiculoPropio(dto.vehiculoPropio());
        alumno.setMasInformacion(dto.masInformacion());
    }
}
