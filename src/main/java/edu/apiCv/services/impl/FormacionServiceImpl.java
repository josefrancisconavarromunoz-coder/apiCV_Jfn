package edu.apiCv.services.impl;

import edu.apiCv.dtos.*;
import edu.apiCv.entities.*;
import edu.apiCv.exceptions.RecursoNotFoundException;
import edu.apiCv.repositories.*;
import edu.apiCv.services.FormacionService;
import org.springframework.stereotype.Service;
import java.util.List;

/** Implementa la lógica de gestión de formacions. */
@Service
public class FormacionServiceImpl implements FormacionService {
    private final FormacionRepository repository;
    private final AlumnoRepository alumnoRepository;

    /** Construye el servicio con los repositorios necesarios.
     * @param repository repositorio de formacions
     */
    public FormacionServiceImpl(FormacionRepository repository, AlumnoRepository alumnoRepository) { this.repository = repository; this.alumnoRepository = alumnoRepository; }

    @Override
    public List<FormacionResponseDto> findAll() { return repository.findAll().stream().map(this::toDto).toList(); }

    @Override
    public FormacionResponseDto findById(Long id) { return toDto(repository.findById(id).orElseThrow(() -> new RecursoNotFoundException("No existe formacion con ID: " + id))); }

    @Override
    public FormacionResponseDto create(FormacionRequestDto dto) { return toDto(repository.save(toEntity(dto))); }

    @Override
    public FormacionResponseDto update(Long id, FormacionRequestDto dto) { Formacion entity = repository.findById(id).orElseThrow(() -> new RecursoNotFoundException("No existe formacion con ID: " + id)); copy(entity, dto); return toDto(repository.save(entity)); }

    @Override
    public void delete(Long id) { if (!repository.existsById(id)) throw new RecursoNotFoundException("No existe formacion con ID: " + id); repository.deleteById(id); }

    private Formacion toEntity(FormacionRequestDto d) { Formacion e = new Formacion(); e.setCentro(d.centro()); e.setTitulo(d.titulo()); e.setCodigoPostal(d.codigoPostal()); e.setFecha(d.fecha()); e.setAlumno(alumnoRepository.findById(d.alumnoId()).orElseThrow(() -> new RecursoNotFoundException("No existe el alumno con ID: " + d.alumnoId()))); return e; }
    private FormacionResponseDto toDto(Formacion e) { return new FormacionResponseDto(e.getId(), e.getCentro(), e.getTitulo(), e.getCodigoPostal(), e.getFecha(), e.getAlumno().getId()); }
    private void copy(Formacion e, FormacionRequestDto d) { e.setCentro(d.centro()); e.setTitulo(d.titulo()); e.setCodigoPostal(d.codigoPostal()); e.setFecha(d.fecha()); e.setAlumno(alumnoRepository.findById(d.alumnoId()).orElseThrow(() -> new RecursoNotFoundException("No existe el alumno con ID: " + d.alumnoId()))); }
    
}
