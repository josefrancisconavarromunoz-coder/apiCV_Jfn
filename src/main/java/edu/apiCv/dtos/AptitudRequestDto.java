package edu.apiCv.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/** Datos necesarios para crear o modificar una aptitud de texto libre. */
public record AptitudRequestDto(@NotBlank @Size(max = 255) String descripcion,
        @NotNull Long alumnoId) { }
