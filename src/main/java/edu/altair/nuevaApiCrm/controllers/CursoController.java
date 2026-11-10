package edu.altair.nuevaApiCrm.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.altair.nuevaApiCrm.dtos.CursoRequestDto;
import edu.altair.nuevaApiCrm.dtos.CursoResponseDto;
import edu.altair.nuevaApiCrm.services.CursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<CursoResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(cursoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<CursoResponseDto> crear(@RequestBody CursoRequestDto requestDto) {
        CursoResponseDto creado = cursoService.crear(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody CursoRequestDto requestDto) {
        return ResponseEntity.ok(cursoService.actualizar(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cursoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
