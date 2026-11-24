package edu.apiCv.controllers;

import edu.apiCv.dtos.AlumnoRequestDto;
import edu.apiCv.dtos.AlumnoResponseDto;
import edu.apiCv.services.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import edu.apiCv.entities.TipoPerfil;

/** Expone los endpoints REST para gestionar alumnos. */
@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
    private final AlumnoService service;

    /** Construye el controlador.
     * @param service servicio de alumnos
     */
    public AlumnoController(AlumnoService service) { this.service = service; }

    /** Obtiene todos los registros.
     * @return lista de registros
     */
    @GetMapping({"", "/"})
    public ResponseEntity<List<AlumnoResponseDto>> findAll() { return ResponseEntity.ok(service.findAllByTipoPerfil(TipoPerfil.ALUMNO)); }

    /** Obtiene un registro por su ID.
     * @param id identificador del registro
     * @return registro encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoResponseDto> findById(@PathVariable Long id) {
        AlumnoResponseDto perfil = service.findById(id);
        if (perfil.tipoPerfil() != TipoPerfil.ALUMNO) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(perfil);
    }

    /** Crea un nuevo registro.
     * @param dto datos recibidos
     * @return registro creado
     */
    @PostMapping
    public ResponseEntity<AlumnoResponseDto> create(@Valid @RequestBody AlumnoRequestDto dto) { return ResponseEntity.status(HttpStatus.CREATED).body(service.create(new AlumnoRequestDto(TipoPerfil.ALUMNO, dto.nombre(), dto.apellidos(), dto.nif(), dto.telefono(), dto.correo(), dto.direccion(), dto.fechaNacimiento(), dto.sobreMi(), dto.carnetConducir(), dto.vehiculoPropio(), dto.masInformacion()))); }

    /** Actualiza un registro existente.
     * @param id identificador del registro
     * @param dto nuevos datos
     
     */
    @PutMapping("/{id}")
    public ResponseEntity<AlumnoResponseDto> update(@PathVariable Long id, @Valid @RequestBody AlumnoRequestDto dto) { if (service.findById(id).tipoPerfil() != TipoPerfil.ALUMNO) return ResponseEntity.notFound().build(); return ResponseEntity.ok(service.update(id, new AlumnoRequestDto(TipoPerfil.ALUMNO, dto.nombre(), dto.apellidos(), dto.nif(), dto.telefono(), dto.correo(), dto.direccion(), dto.fechaNacimiento(), dto.sobreMi(), dto.carnetConducir(), dto.vehiculoPropio(), dto.masInformacion()))); }

    /** Elimina un registro.
     * @param id identificador del registro
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { if (service.findById(id).tipoPerfil() != TipoPerfil.ALUMNO) return ResponseEntity.notFound().build(); service.delete(id); return ResponseEntity.noContent().build(); }

    /** Permite consultar los currículums publicados por profesores.
     * @return lista de currículums de profesores
     */
    @GetMapping("/profesores")
    public ResponseEntity<List<AlumnoResponseDto>> findProfesores() {
        return ResponseEntity.ok(service.findAllByTipoPerfil(TipoPerfil.PROFESOR));
    }

    /** Permite consultar los currículums de alumnos.
     * @return lista de currículums de alumnos
     */
    @GetMapping("/alumnos")
    public ResponseEntity<List<AlumnoResponseDto>> findAlumnos() {
        return ResponseEntity.ok(service.findAllByTipoPerfil(TipoPerfil.ALUMNO));
    }
}
