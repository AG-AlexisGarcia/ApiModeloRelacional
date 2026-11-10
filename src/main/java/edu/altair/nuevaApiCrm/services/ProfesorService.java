package edu.altair.nuevaApiCrm.services; // Asegúrate de que coincida con tu paquete

import java.util.List;

import edu.altair.nuevaApiCrm.dtos.ProfesorRequestDto;
import edu.altair.nuevaApiCrm.dtos.ProfesorResponseDto;

public interface ProfesorService {
    
    List<ProfesorResponseDto> obtenerTodos();
    
    ProfesorResponseDto getById(Long id); // <-- Añadido para quitar el error en ProfesorServiceImpl
    
    ProfesorResponseDto crear(ProfesorRequestDto requestDto);
    
    ProfesorResponseDto actualizar(Long id, ProfesorRequestDto requestDto);
    
    void eliminar(Long id);
}