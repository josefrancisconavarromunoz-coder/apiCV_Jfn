package edu.apiCv.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

/** Representa los datos personales y la información general de un alumno. */
@Entity
@Table(name = "alumnos")
public class Alumno {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoPerfil tipoPerfil = TipoPerfil.ALUMNO;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false, length = 150)
    private String apellidos;
    @Column(length = 20)
    private String nif;
    @Column(length = 20)
    private String telefono;
    @Column(length = 150)
    private String correo;
    @Column(length = 200)
    private String direccion;
    private LocalDate fechaNacimiento;
    @Column(length = 1000)
    private String sobreMi;
    private Boolean carnetConducir;
    private Boolean vehiculoPropio;
    @Column(length = 1000)
    private String masInformacion;

    /** Constructor vacío requerido por JPA. */
    public Alumno() { }

    public Long getId() { return id; }
    /** Obtiene el tipo de perfil. @return tipo de perfil */
    public TipoPerfil getTipoPerfil() { return tipoPerfil; }
    /** Establece el tipo de perfil. @param tipoPerfil tipo de perfil */
    public void setTipoPerfil(TipoPerfil tipoPerfil) { this.tipoPerfil = tipoPerfil; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getNif() { return nif; }
    public void setNif(String nif) { this.nif = nif; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public String getSobreMi() { return sobreMi; }
    public void setSobreMi(String sobreMi) { this.sobreMi = sobreMi; }
    public Boolean getCarnetConducir() { return carnetConducir; }
    public void setCarnetConducir(Boolean carnetConducir) { this.carnetConducir = carnetConducir; }
    public Boolean getVehiculoPropio() { return vehiculoPropio; }
    public void setVehiculoPropio(Boolean vehiculoPropio) { this.vehiculoPropio = vehiculoPropio; }
    public String getMasInformacion() { return masInformacion; }
    public void setMasInformacion(String masInformacion) { this.masInformacion = masInformacion; }
}
