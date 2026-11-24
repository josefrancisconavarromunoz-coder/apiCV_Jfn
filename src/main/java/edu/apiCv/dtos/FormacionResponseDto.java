package edu.apiCv.dtos;

import java.time.LocalDate;

/** Datos de formación que devuelve la api */
public record FormacionResponseDto(Long id, String centro, String titulo,
        String codigoPostal, LocalDate fecha, Long alumnoId) { }
