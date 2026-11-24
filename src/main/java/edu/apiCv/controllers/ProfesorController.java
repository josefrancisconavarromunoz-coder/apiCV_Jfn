package edu.apiCv.controllers;

import edu.apiCv.dtos.AlumnoRequestDto;
import edu.apiCv.dtos.AlumnoResponseDto;
import edu.apiCv.entities.TipoPerfil;
import edu.apiCv.services.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/** Expone las operaciones de consulta y edición de currículums de profesores. */
@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {
    private final AlumnoService service;

    /** Construye el controlador.
     * @param service servicio que gestiona los currículums
     */
    public ProfesorController(AlumnoService service) {
        this.service = service;
    }

    /** Consulta todos los currículums de profesores.
     * @return lista de currículums
     */
    @GetMapping
    public ResponseEntity<List<AlumnoResponseDto>> findAll() {
        return ResponseEntity.ok(service.findAllByTipoPerfil(TipoPerfil.PROFESOR));
    }

    /** Consulta un currículum de profesor por su ID.
     * @param id identificador del perfil
     * @return currículum encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoResponseDto> findById(@PathVariable Long id) {
        AlumnoResponseDto perfil = service.findById(id);
        if (perfil.tipoPerfil() != TipoPerfil.PROFESOR) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(perfil);
    }

    /** Crea un currículum de profesor.
     * @param dto datos del profesor
     * @return currículum creado
     */
    @PostMapping
    public ResponseEntity<AlumnoResponseDto> create(@Valid @RequestBody AlumnoRequestDto dto) {
        AlumnoRequestDto datos = new AlumnoRequestDto(TipoPerfil.PROFESOR, dto.nombre(),
                dto.apellidos(), dto.nif(), dto.telefono(), dto.correo(), dto.direccion(),
                dto.fechaNacimiento(), dto.sobreMi(), dto.carnetConducir(),
                dto.vehiculoPropio(), dto.masInformacion());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(datos));
    }

    /** Actualiza un currículum de profesor.
     * @param id identificador del perfil
     * @param dto nuevos datos
     * @return currículum actualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<AlumnoResponseDto> update(@PathVariable Long id,
            @Valid @RequestBody AlumnoRequestDto dto) {
        AlumnoResponseDto actual = service.findById(id);
        if (actual.tipoPerfil() != TipoPerfil.PROFESOR) {
            return ResponseEntity.notFound().build();
        }
        AlumnoRequestDto datos = new AlumnoRequestDto(TipoPerfil.PROFESOR, dto.nombre(),
                dto.apellidos(), dto.nif(), dto.telefono(), dto.correo(), dto.direccion(),
                dto.fechaNacimiento(), dto.sobreMi(), dto.carnetConducir(),
                dto.vehiculoPropio(), dto.masInformacion());
        return ResponseEntity.ok(service.update(id, datos));
    }
}
