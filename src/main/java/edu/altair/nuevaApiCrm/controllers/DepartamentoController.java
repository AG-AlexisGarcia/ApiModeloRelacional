package edu.altair.nuevaApiCrm.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.altair.nuevaApiCrm.dtos.DepartamentoRequestDto;
import edu.altair.nuevaApiCrm.dtos.DepartamentoResponseDto;
import edu.altair.nuevaApiCrm.services.DepartamentoService;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(departamentoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(departamentoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<DepartamentoResponseDto> crear(@RequestBody DepartamentoRequestDto requestDto) {
        DepartamentoResponseDto creado = departamentoService.crear(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody DepartamentoRequestDto requestDto) {
        return ResponseEntity.ok(departamentoService.actualizar(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        departamentoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}