package edu.altair.nuevaApiCrm.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.altair.nuevaApiCrm.dtos.FamiliaRequestDto;
import edu.altair.nuevaApiCrm.dtos.FamiliaResponseDto;
import edu.altair.nuevaApiCrm.services.FamiliaService;

@RestController
@RequestMapping("/api/familias")
public class FamiliaController {

    private final FamiliaService familiaService;

    public FamiliaController(FamiliaService familiaService) {
        this.familiaService = familiaService;
    }

    @GetMapping
    public ResponseEntity<List<FamiliaResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(familiaService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamiliaResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(familiaService.getById(id));
    }

    @PostMapping
    public ResponseEntity<FamiliaResponseDto> crear(@RequestBody FamiliaRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(familiaService.crear(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FamiliaResponseDto> actualizar(@PathVariable Long id, @RequestBody FamiliaRequestDto requestDto) {
        return ResponseEntity.ok(familiaService.actualizar(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        familiaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}