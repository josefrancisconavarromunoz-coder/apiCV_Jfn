package edu.apiCv.dtos;

import java.time.LocalDate;

/** Datos de experiencia laboral que devuelve la api */
public record ExperienciaResponseDto(Long id, String empresa, String puesto,
        LocalDate fecha, String descripcion, Long alumnoId) { }
