package edu.altair.nuevaApiCrm.services;

import java.util.List;
import edu.altair.nuevaApiCrm.dtos.FamiliaRequestDto;
import edu.altair.nuevaApiCrm.dtos.FamiliaResponseDto;

public interface FamiliaService {
    List<FamiliaResponseDto> obtenerTodos();
    FamiliaResponseDto getById(Long id);
    FamiliaResponseDto crear(FamiliaRequestDto requestDto);
    FamiliaResponseDto actualizar(Long id, FamiliaRequestDto requestDto);
    void eliminar(Long id);
} 
