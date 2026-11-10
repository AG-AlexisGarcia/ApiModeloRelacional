package edu.altair.nuevaApiCrm.services;

import java.util.List;
import edu.altair.nuevaApiCrm.dtos.CursoRequestDto;
import edu.altair.nuevaApiCrm.dtos.CursoResponseDto;

public interface CursoService {
    List<CursoResponseDto> obtenerTodos();
    CursoResponseDto getById(Long id);
    CursoResponseDto crear(CursoRequestDto requestDto);
    CursoResponseDto actualizar(Long id, CursoRequestDto requestDto);
    void eliminar(Long id);
}