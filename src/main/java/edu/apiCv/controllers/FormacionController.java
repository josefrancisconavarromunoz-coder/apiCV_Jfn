package edu.apiCv.controllers;

import edu.apiCv.dtos.FormacionRequestDto;
import edu.apiCv.dtos.FormacionResponseDto;
import edu.apiCv.services.FormacionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/** Expone los endpoints REST para gestionar formacions. */
@RestController
@RequestMapping("/api/formaciones")
public class FormacionController {
    private final FormacionService service;

    /** Construye el controlador.
     * @param service servicio de formacions
     */
    public FormacionController(FormacionService service) { this.service = service; }

    /** Obtiene todos los registros.
     * @return lista de registros
     */
    @GetMapping
    public ResponseEntity<List<FormacionResponseDto>> findAll() { return ResponseEntity.ok(service.findAll()); }

    /** Obtiene un registro por su ID.
     * @param id identificador del registro
     * @return registro encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<FormacionResponseDto> findById(@PathVariable Long id) { return ResponseEntity.ok(service.findById(id)); }

    /** Crea un nuevo registro.
     * @param dto datos recibidos
     * @return registro creado
     */
    @PostMapping
    public ResponseEntity<FormacionResponseDto> create(@Valid @RequestBody FormacionRequestDto dto) { return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto)); }

    /** Actualiza un registro existente.
     * @param id identificador del registro
     * @param dto nuevos datos
     * @return registro actualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<FormacionResponseDto> update(@PathVariable Long id, @Valid @RequestBody FormacionRequestDto dto) { return ResponseEntity.ok(service.update(id, dto)); }

    /** Elimina un registro.
     * @param id identificador del registro
     * @return respuesta sin contenido
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
