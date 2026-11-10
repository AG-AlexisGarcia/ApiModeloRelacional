package edu.altair.nuevaApiCrm.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.altair.nuevaApiCrm.dtos.ModuloRequestDto;
import edu.altair.nuevaApiCrm.dtos.ModuloResponseDto;
import edu.altair.nuevaApiCrm.services.ModuloService;

@RestController
@RequestMapping("/api/modulos")
public class ModuloController {

    private final ModuloService moduloService;

    public ModuloController(ModuloService moduloService) {
        this.moduloService = moduloService;
    }

    @GetMapping
    public ResponseEntity<List<ModuloResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(moduloService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuloResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(moduloService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ModuloResponseDto> crear(@RequestBody ModuloRequestDto requestDto) {
        ModuloResponseDto creado = moduloService.crear(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModuloResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody ModuloRequestDto requestDto) {
        return ResponseEntity.ok(moduloService.actualizar(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        moduloService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}