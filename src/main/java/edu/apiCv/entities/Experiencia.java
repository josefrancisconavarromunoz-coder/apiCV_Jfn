package edu.apiCv.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

/** Representa una experiencia laboral incluida en el currículum de un alumno. */
@Entity
@Table(name = "experiencias")
public class Experiencia {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String empresa;
    @Column(nullable = false, length = 150)
    private String puesto;
    private LocalDate fecha;
    @Column(length = 1000)
    private String descripcion;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;

    /** Constructor vacío requerido por jpa */
    public Experiencia() { }
    public Long getId() { return id; }
    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }
    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Alumno getAlumno() { return alumno; }
    public void setAlumno(Alumno alumno) { this.alumno = alumno; }
}
