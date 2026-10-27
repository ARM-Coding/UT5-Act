package edu.altair.crm.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "asignaturas")
public class Asignatura {

    @Id
    @Column(name = "codigo_asignatura", length = 10)
    private String codigoAsignatura;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    // Lado propietario: contiene la clave foránea dni_profesor
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dni_profesor", nullable = false, foreignKey = @ForeignKey(name = "fk_asignaturas_profesor"))
    private Profesor profesor;

    public Asignatura() {}

    public Asignatura(String codigoAsignatura, String nombre, Profesor profesor) {
        this.codigoAsignatura = codigoAsignatura;
        this.nombre = nombre;
        this.profesor = profesor;
    }

    // Getters y Setters
    public String getCodigoAsignatura() { return codigoAsignatura; }
    public void setCodigoAsignatura(String codigoAsignatura) { this.codigoAsignatura = codigoAsignatura; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Profesor getProfesor() { return profesor; }
    public void setProfesor(Profesor profesor) { this.profesor = profesor; }
}