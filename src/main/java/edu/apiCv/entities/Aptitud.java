package edu.apiCv.entities;

import jakarta.persistence.*;

/** Representa una aptitud expresada como texto libre en el currículum de un alumno. */
@Entity
@Table(name = "aptitudes")
public class Aptitud {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 255)
    private String descripcion;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;

    /** Constructor vacío requerido por jpa */
    public Aptitud() { }
    public Long getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Alumno getAlumno() { return alumno; }
    public void setAlumno(Alumno alumno) { this.alumno = alumno; }
}
