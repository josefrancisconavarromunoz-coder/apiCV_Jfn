package edu.apiCv.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

/** Datos necesarios para crear o modificar una formación. */
public record FormacionRequestDto(@NotBlank @Size(max = 150) String centro,
        @NotBlank @Size(max = 200) String titulo, @Size(max = 10) String codigoPostal,
        LocalDate fecha, @NotNull Long alumnoId) { }
