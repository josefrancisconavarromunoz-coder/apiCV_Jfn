package edu.apiCv.services.impl;

import edu.apiCv.dtos.*;
import edu.apiCv.entities.*;
import edu.apiCv.exceptions.RecursoNotFoundException;
import edu.apiCv.repositories.*;
import edu.apiCv.services.AptitudService;
import org.springframework.stereotype.Service;
import java.util.List;

/** Implementa la lógica de gestión de aptituds. */
@Service
public class AptitudServiceImpl implements AptitudService {
    private final AptitudRepository repository;
    private final AlumnoRepository alumnoRepository;

    /** Construye el servicio con los repositorios necesarios.
     * @param repository repositorio de aptituds
     */
    public AptitudServiceImpl(AptitudRepository repository, AlumnoRepository alumnoRepository) { this.repository = repository; this.alumnoRepository = alumnoRepository; }

    @Override
    public List<AptitudResponseDto> findAll() { return repository.findAll().stream().map(this::toDto).toList(); }

    @Override
    public AptitudResponseDto findById(Long id) { return toDto(repository.findById(id).orElseThrow(() -> new RecursoNotFoundException("No existe aptitud con ID: " + id))); }

    @Override
    public AptitudResponseDto create(AptitudRequestDto dto) { return toDto(repository.save(toEntity(dto))); }

    @Override
    public AptitudResponseDto update(Long id, AptitudRequestDto dto) { Aptitud entity = repository.findById(id).orElseThrow(() -> new RecursoNotFoundException("No existe aptitud con ID: " + id)); copy(entity, dto); return toDto(repository.save(entity)); }

    @Override
    public void delete(Long id) { if (!repository.existsById(id)) throw new RecursoNotFoundException("No existe aptitud con ID: " + id); repository.deleteById(id); }

    private Aptitud toEntity(AptitudRequestDto d) { Aptitud e = new Aptitud(); e.setDescripcion(d.descripcion()); e.setAlumno(alumnoRepository.findById(d.alumnoId()).orElseThrow(() -> new RecursoNotFoundException("No existe el alumno con ID: " + d.alumnoId()))); return e; }
    private AptitudResponseDto toDto(Aptitud e) { return new AptitudResponseDto(e.getId(), e.getDescripcion(), e.getAlumno().getId()); }
    private void copy(Aptitud e, AptitudRequestDto d) { e.setDescripcion(d.descripcion()); e.setAlumno(alumnoRepository.findById(d.alumnoId()).orElseThrow(() -> new RecursoNotFoundException("No existe el alumno con ID: " + d.alumnoId()))); }
    
}
