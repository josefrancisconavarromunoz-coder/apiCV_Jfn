package edu.apiCv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Clase principal que inicia la API REST de currículum. */
@SpringBootApplication
public class ApiCvApplication {

    /** Inicia la aplicación Spring Boot.
     * @param args argumentos recibidos al ejecutar la aplicación
     * @author curro
     */
    public static void main(String[] args) {
        SpringApplication.run(ApiCvApplication.class, args);
    }
}
