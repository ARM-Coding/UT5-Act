package edu.altair.crm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "faltas")
public class Falta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_falta")
    private Long idFalta;

    @Column(name = "id_alumno", nullable = false)
    private Long idAlumno;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "materia", nullable = false, length = 100)
    private String materia;

    @Column(name = "justificada", nullable = false)
    private boolean justificada;

    @Column(name = "motivo_justificacion", length = 255)
    private String motivoJustificacion;

    // Constructor sin argumentos (Requerido por JPA/Hibernate)
    public Falta() {}

    // Constructor de conveniencia para registrar una nueva falta
    public Falta(Long idAlumno, LocalDate fecha, String materia) {
        this.idAlumno = idAlumno;
        this.fecha = fecha;
        this.materia = materia;
        this.justificada = false; // Por defecto nace sin justificar
    }

    // Getters y Setters
    public Long getIdFalta() {
        return idFalta;
    }

    public void setIdFalta(Long idFalta) {
        this.idFalta = idFalta;
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public boolean isJustificada() {
        return justificada;
    }

    public void setJustificada(boolean justificada) {
        this.justificada = justificada;
    }

    public String getMotivoJustificacion() {
        return motivoJustificacion;
    }

    public void setMotivoJustificacion(String motivoJustificacion) {
        this.motivoJustificacion = motivoJustificacion;
    }
}