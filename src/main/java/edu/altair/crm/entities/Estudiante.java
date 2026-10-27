package edu.altair.crm.entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @Column(name = "dni", length = 9)
    private String dni;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    // Relación 1:N hacia la entidad intermedia Matriculacion.
    // Se utiliza Set para evitar duplicados y optimizar rendimiento.
    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Matriculacion> matriculaciones = new HashSet<>();

    public Estudiante() {}

    public Estudiante(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Set<Matriculacion> getMatriculaciones() { return matriculaciones; }
    public void setMatriculaciones(Set<Matriculacion> matriculaciones) { this.matriculaciones = matriculaciones; }
}
