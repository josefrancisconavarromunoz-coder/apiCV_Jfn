package edu.apiCv.services.impl;

import edu.apiCv.dtos.*;
import edu.apiCv.entities.*;
import edu.apiCv.exceptions.RecursoNotFoundException;
import edu.apiCv.repositories.*;
import edu.apiCv.services.ExperienciaService;
import org.springframework.stereotype.Service;
import java.util.List;

/** Implementa la lógica de gestión de experiencias. */
@Service
public class ExperienciaServiceImpl implements ExperienciaService {
    private final ExperienciaRepository repository;
    private final AlumnoRepository alumnoRepository;

    /** Construye el servicio con los repositorios necesarios.
     * @param repository repositorio de experiencias
     */
    public ExperienciaServiceImpl(ExperienciaRepository repository, AlumnoRepository alumnoRepository) { this.repository = repository; this.alumnoRepository = alumnoRepository; }

    @Override
    public List<ExperienciaResponseDto> findAll() { return repository.findAll().stream().map(this::toDto).toList(); }

    @Override
    public ExperienciaResponseDto findById(Long id) { return toDto(repository.findById(id).orElseThrow(() -> new RecursoNotFoundException("No existe experiencia con ID: " + id))); }

    @Override
    public ExperienciaResponseDto create(ExperienciaRequestDto dto) { return toDto(repository.save(toEntity(dto))); }

    @Override
    public ExperienciaResponseDto update(Long id, ExperienciaRequestDto dto) { Experiencia entity = repository.findById(id).orElseThrow(() -> new RecursoNotFoundException("No existe experiencia con ID: " + id)); copy(entity, dto); return toDto(repository.save(entity)); }

    @Override
    public void delete(Long id) { if (!repository.existsById(id)) throw new RecursoNotFoundException("No existe experiencia con ID: " + id); repository.deleteById(id); }

    private Experiencia toEntity(ExperienciaRequestDto d) { Experiencia e = new Experiencia(); e.setEmpresa(d.empresa()); e.setPuesto(d.puesto()); e.setFecha(d.fecha()); e.setDescripcion(d.descripcion()); e.setAlumno(alumnoRepository.findById(d.alumnoId()).orElseThrow(() -> new RecursoNotFoundException("No existe el alumno con ID: " + d.alumnoId()))); return e; }
    private ExperienciaResponseDto toDto(Experiencia e) { return new ExperienciaResponseDto(e.getId(), e.getEmpresa(), e.getPuesto(), e.getFecha(), e.getDescripcion(), e.getAlumno().getId()); }
    private void copy(Experiencia e, ExperienciaRequestDto d) { e.setEmpresa(d.empresa()); e.setPuesto(d.puesto()); e.setFecha(d.fecha()); e.setDescripcion(d.descripcion()); e.setAlumno(alumnoRepository.findById(d.alumnoId()).orElseThrow(() -> new RecursoNotFoundException("No existe el alumno con ID: " + d.alumnoId()))); }
    
}
