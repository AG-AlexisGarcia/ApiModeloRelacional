package edu.altair.nuevaApiCrm.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.altair.nuevaApiCrm.dtos.TitulacionRequestDto;
import edu.altair.nuevaApiCrm.dtos.TitulacionResponseDto;
import edu.altair.nuevaApiCrm.services.TitulacionService;

@RestController
@RequestMapping("/api/titulaciones")
public class TitulacionController {

    private final TitulacionService titulacionService;

    public TitulacionController(TitulacionService titulacionService) {
        this.titulacionService = titulacionService;
    }

    @GetMapping
    public ResponseEntity<List<TitulacionResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(titulacionService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TitulacionResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(titulacionService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TitulacionResponseDto> crear(@RequestBody TitulacionRequestDto requestDto) {
        TitulacionResponseDto creada = titulacionService.crear(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TitulacionResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody TitulacionRequestDto requestDto) {
        return ResponseEntity.ok(titulacionService.actualizar(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        titulacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
