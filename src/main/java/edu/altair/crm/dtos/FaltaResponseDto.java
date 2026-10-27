package edu.altair.crm.dtos;

import java.time.LocalDate;

public record FaltaResponseDto(
    Long idFalta,
    Long idAlumno,
    LocalDate fecha,
    String materia,
    boolean justificada,
    String motivoJustificacion
) {}