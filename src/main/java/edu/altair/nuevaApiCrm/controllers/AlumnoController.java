package edu.altair.nuevaApiCrm.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.altair.nuevaApiCrm.dtos.AlumnoRequestDto;
import edu.altair.nuevaApiCrm.dtos.AlumnoResponseDto;
import edu.altair.nuevaApiCrm.services.AlumnoService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping
    public ResponseEntity<List<AlumnoResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(alumnoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alumnoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<AlumnoResponseDto> crear(@RequestBody AlumnoRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.crear(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoResponseDto> actualizar(@PathVariable Long id, @RequestBody AlumnoRequestDto requestDto) {
        return ResponseEntity.ok(alumnoService.actualizar(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        alumnoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}