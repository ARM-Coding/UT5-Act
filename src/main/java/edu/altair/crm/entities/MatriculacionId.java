package edu.altair.crm.entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MatriculacionId implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dniEstudiante;
    private String codigoAsignatura;

    public MatriculacionId() {}

    public MatriculacionId(String dniEstudiante, String codigoAsignatura) {
        this.dniEstudiante = dniEstudiante;
        this.codigoAsignatura = codigoAsignatura;
    }

    public String getDniEstudiante() { return dniEstudiante; }
    public void setDniEstudiante(String dniEstudiante) { this.dniEstudiante = dniEstudiante; }

    public String getCodigoAsignatura() { return codigoAsignatura; }
    public void setCodigoAsignatura(String codigoAsignatura) { this.codigoAsignatura = codigoAsignatura; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatriculacionId that = (MatriculacionId) o;
        return Objects.equals(dniEstudiante, that.dniEstudiante) &&
               Objects.equals(codigoAsignatura, that.codigoAsignatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dniEstudiante, codigoAsignatura);
    }
}