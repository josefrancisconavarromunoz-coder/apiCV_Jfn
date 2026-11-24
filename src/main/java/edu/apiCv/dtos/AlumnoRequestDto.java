package edu.apiCv.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import edu.apiCv.entities.TipoPerfil;

/** Datos necesarios para crear o modificar un alumno. */
public record AlumnoRequestDto(
        TipoPerfil tipoPerfil,
        @NotBlank @Size(max = 100) String nombre,
        @NotBlank @Size(max = 150) String apellidos,
        @Size(max = 20) String nif,
        @Size(max = 20) String telefono,
        @Size(max = 150) String correo,
        @Size(max = 200) String direccion,
        LocalDate fechaNacimiento,
        @Size(max = 1000) String sobreMi,
        Boolean carnetConducir,
        Boolean vehiculoPropio,
        @Size(max = 1000) String masInformacion) { }
