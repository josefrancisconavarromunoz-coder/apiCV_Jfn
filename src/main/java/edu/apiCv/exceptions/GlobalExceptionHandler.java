package edu.apiCv.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.LinkedHashMap;
import java.util.Map;

/** Centraliza el tratamiento de errores de los controladores REST. */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /** Convierte los recursos inexistentes en respuestas HTTP 404.
     * @param ex excepción producida por el servicio
     * @return respuesta con el mensaje y el estado 404
     */
    @ExceptionHandler(RecursoNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(RecursoNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage()));
    }

    /** Devuelve los errores de validación como respuestas HTTP 400.
     * @param ex excepción de validación
     * @return campos que no han superado la validación
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new LinkedHashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errores.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errores);
    }
}
