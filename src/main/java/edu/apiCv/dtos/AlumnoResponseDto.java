package edu.apiCv.dtos;

import java.time.LocalDate;
import edu.apiCv.entities.TipoPerfil;

/** Datos de alumno que devuelve la api. */
public record AlumnoResponseDto(Long id, TipoPerfil tipoPerfil, String nombre, String apellidos, String nif,
        String telefono, String correo, String direccion, LocalDate fechaNacimiento,
        String sobreMi, Boolean carnetConducir, Boolean vehiculoPropio, String masInformacion) { }
