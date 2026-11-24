package edu.apiCv.exceptions;

/** Excepción que indica que el recurso solicitado no existe. */
public class RecursoNotFoundException extends RuntimeException {
    /** Crea la excepción con el mensaje indicado.
     * @param mensaje descripción del recurso no encontrado
     */
    public RecursoNotFoundException(String mensaje) { super(mensaje); }
}
