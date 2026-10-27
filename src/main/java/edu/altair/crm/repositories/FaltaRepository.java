package edu.altair.crm.repositories;

import edu.altair.crm.entities.Falta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaltaRepository extends JpaRepository<Falta, Long> {

    // Método derivado para obtener las faltas NO justificadas de un alumno específico
    List<Falta> findByIdAlumnoAndJustificadaFalse(Long idAlumno);

    // Método derivado para obtener el historial completo de faltas de un alumno
    List<Falta> findByIdAlumno(Long idAlumno);
}