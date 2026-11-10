package edu.altair.nuevaApiCrm.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.altair.nuevaApiCrm.dtos.ProfesorRequestDto;
import edu.altair.nuevaApiCrm.dtos.ProfesorResponseDto;
import edu.altair.nuevaApiCrm.services.ProfesorService;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {
    
    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }
    
    @GetMapping
    public ResponseEntity<List<ProfesorResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(profesorService.obtenerTodos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProfesorResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(profesorService.getById(id));
    }
    
    @PostMapping
    public ResponseEntity<ProfesorResponseDto> crear(@RequestBody ProfesorRequestDto requestDto) {
        ProfesorResponseDto creado = profesorService.crear(requestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesorResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody ProfesorRequestDto requestDto) {
        ProfesorResponseDto actualizado = profesorService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        profesorService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}