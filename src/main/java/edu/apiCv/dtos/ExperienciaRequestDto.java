package edu.apiCv.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

/** Datos necesarios para crear o modificar una experiencia laboral. */
public record ExperienciaRequestDto(@NotBlank @Size(max = 150) String empresa,
        @NotBlank @Size(max = 150) String puesto, LocalDate fecha,
        @Size(max = 1000) String descripcion, @NotNull Long alumnoId) { }
