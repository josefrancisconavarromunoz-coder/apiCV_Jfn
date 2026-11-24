package edu.apiCv.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

/** Representa una formación académica de un alumno. */
@Entity
@Table(name = "formaciones")
public class Formacion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String centro;
    @Column(nullable = false, length = 200)
    private String titulo;
    @Column(length = 10)
    private String codigoPostal;
    private LocalDate fecha;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;

    /** Constructor vacío requerido por jpa */
    public Formacion() { }
    public Long getId() { return id; }
    public String getCentro() { return centro; }
    public void setCentro(String centro) { this.centro = centro; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public Alumno getAlumno() { return alumno; }
    public void setAlumno(Alumno alumno) { this.alumno = alumno; }
}
