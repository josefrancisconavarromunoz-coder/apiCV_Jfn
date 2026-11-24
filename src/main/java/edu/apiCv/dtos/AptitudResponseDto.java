package edu.apiCv.dtos;

/** Datos de aptitud que devuelve la api */
public record AptitudResponseDto(Long id, String descripcion, Long alumnoId) { }
