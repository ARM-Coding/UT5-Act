package edu.altair.crm.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "matriculaciones")
public class Matriculacion {

    @EmbeddedId
    private MatriculacionId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("dniEstudiante")
    @JoinColumn(name = "dni_estudiante", foreignKey = @ForeignKey(name = "fk_matriculaciones_estudiante"))
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("codigoAsignatura")
    @JoinColumn(name = "codigo_asignatura", foreignKey = @ForeignKey(name = "fk_matriculaciones_asignatura"))
    private Asignatura asignatura;

    @Column(name = "fecha_matriculacion", nullable = false)
    private LocalDate fechaMatriculacion;

    @Column(name = "nota_final")
    private Double notaFinal;

    public Matriculacion() {}

    public Matriculacion(Estudiante estudiante, Asignatura asignatura, LocalDate fechaMatriculacion, Double notaFinal) {
        this.id = new MatriculacionId(estudiante.getDni(), asignatura.getCodigoAsignatura());
        this.estudiante = estudiante;
        this.asignatura = asignatura;
        this.fechaMatriculacion = fechaMatriculacion;
        this.notaFinal = notaFinal;
    }

    // Getters y Setters
    public MatriculacionId getId() { return id; }
    public void setId(MatriculacionId id) { this.id = id; }

    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }

    public Asignatura getAsignatura() { return asignatura; }
    public void setAsignatura(Asignatura asignatura) { this.asignatura = asignatura; }

    public LocalDate getFechaMatriculacion() { return fechaMatriculacion; }
    public void setFechaMatriculacion(LocalDate fechaMatriculacion) { this.fechaMatriculacion = fechaMatriculacion; }

    public Double getNotaFinal() { return notaFinal; }
    public void setNotaFinal(Double notaFinal) { this.notaFinal = notaFinal; }
}