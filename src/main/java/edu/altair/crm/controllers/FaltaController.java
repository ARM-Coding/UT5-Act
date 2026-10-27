package edu.altair.crm.controllers;

import edu.altair.crm.dtos.FaltaResponseDto;
import edu.altair.crm.dtos.JustificarFaltaRequestDto;
import edu.altair.crm.services.FaltaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/faltas")
public class FaltaController {

    private final FaltaService faltaService;

    // Inyección de dependencias por constructor
    public FaltaController(FaltaService faltaService) {
        this.faltaService = faltaService;
    }

    /**
     * GET /api/v1/faltas/alumno/{idAlumno}/sin-justificar
     * Obtiene la lista de faltas sin justificar para un alumno concreto.
     */
    @GetMapping("/alumno/{idAlumno}/sin-justificar")
    public ResponseEntity<List<FaltaResponseDto>> obtenerFaltasSinJustificar(@PathVariable Long idAlumno) {
        List<FaltaResponseDto> faltas = faltaService.obtenerFaltasSinJustificar(idAlumno);
        return ResponseEntity.ok(faltas);
    }

    /**
     * PATCH /api/v1/faltas/{idFalta}/justificar
     * Modifica parcialmente una falta para cambiar su estado a justificada.
     */
    @PatchMapping("/{idFalta}/justificar")
    public ResponseEntity<FaltaResponseDto> justificarFalta(
            @PathVariable Long idFalta,
            @RequestBody JustificarFaltaRequestDto request) {
        FaltaResponseDto faltaJustificada = faltaService.justificarFalta(idFalta, request);
        return ResponseEntity.ok(faltaJustificada);
    }
}