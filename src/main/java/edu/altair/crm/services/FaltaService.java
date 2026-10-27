package edu.altair.crm.services;

import edu.altair.crm.dtos.FaltaResponseDto;
import edu.altair.crm.dtos.JustificarFaltaRequestDto;
import edu.altair.crm.entities.Falta;
import edu.altair.crm.repositories.FaltaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FaltaService {

    private final FaltaRepository faltaRepository;

    // Inyección de dependencias por constructor
    public FaltaService(FaltaRepository faltaRepository) {
        this.faltaRepository = faltaRepository;
    }

    /**
     * Obtiene la lista de faltas NO justificadas de un alumno concreto.
     */
    @Transactional(readOnly = true)
    public List<FaltaResponseDto> obtenerFaltasSinJustificar(Long idAlumno) {
        return faltaRepository.findByIdAlumnoAndJustificadaFalse(idAlumno)
                .stream()
                .map(this::mapearADto)
                .toList();
    }

    /**
     * Justifica una falta existente cambiando su estado y registrando el motivo.
     */
    @Transactional
    public FaltaResponseDto justificarFalta(Long idFalta, JustificarFaltaRequestDto request) {
        Falta falta = faltaRepository.findById(idFalta)
                .orElseThrow(() -> new RuntimeException("Falta no encontrada con ID: " + idFalta));

        falta.setJustificada(true);
        falta.setMotivoJustificacion(request.motivo());

        Falta faltaActualizada = faltaRepository.save(falta);
        return mapearADto(faltaActualizada);
    }

    /**
     * Método privado auxiliar para mapear una entidad Falta a FaltaResponseDto.
     */
    private FaltaResponseDto mapearADto(Falta falta) {
        return new FaltaResponseDto(
                falta.getIdFalta(),
                falta.getIdAlumno(),
                falta.getFecha(),
                falta.getMateria(),
                falta.isJustificada(),
                falta.getMotivoJustificacion()
        );
    }
}