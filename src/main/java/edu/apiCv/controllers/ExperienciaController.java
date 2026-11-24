package edu.apiCv.controllers;

import edu.apiCv.dtos.ExperienciaRequestDto;
import edu.apiCv.dtos.ExperienciaResponseDto;
import edu.apiCv.services.ExperienciaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/** Expone los endpoints REST para gestionar experiencias. */
@RestController
@RequestMapping("/api/experiencias")
public class ExperienciaController {
    private final ExperienciaService service;

    /** Construye el controlador.
     * @param service servicio de experiencias
     */
    public ExperienciaController(ExperienciaService service) { this.service = service; }

    /** Obtiene todos los registros.
     * @return lista de registros
     */
    @GetMapping
    public ResponseEntity<List<ExperienciaResponseDto>> findAll() { return ResponseEntity.ok(service.findAll()); }

    /** Obtiene un registro por su ID.
     * @param id identificador del registro
     * @return registro encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<ExperienciaResponseDto> findById(@PathVariable Long id) { return ResponseEntity.ok(service.findById(id)); }

    /** Crea un nuevo registro.
     * @param dto datos recibidos
     * @return registro creado
     */
    @PostMapping
    public ResponseEntity<ExperienciaResponseDto> create(@Valid @RequestBody ExperienciaRequestDto dto) { return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto)); }

    /** Actualiza un registro existente.
     * @param id identificador del registro
     * @param dto nuevos datos
     * @return registro actualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<ExperienciaResponseDto> update(@PathVariable Long id, @Valid @RequestBody ExperienciaRequestDto dto) { return ResponseEntity.ok(service.update(id, dto)); }

    /** Elimina un registro.
     * @param id identificador del registro
     * @return respuesta sin contenido
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
