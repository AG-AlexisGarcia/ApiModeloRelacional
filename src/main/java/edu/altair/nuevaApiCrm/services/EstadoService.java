package edu.altair.nuevaApiCrm.services;

import java.util.List;
import edu.altair.nuevaApiCrm.dtos.EstadoRequestDto;
import edu.altair.nuevaApiCrm.dtos.EstadoResponseDto;

public interface EstadoService {
    List<EstadoResponseDto> obtenerTodos();
    EstadoResponseDto getById(Long id);
    EstadoResponseDto crear(EstadoRequestDto requestDto);
    EstadoResponseDto actualizar(Long id, EstadoRequestDto requestDto);
    void eliminar(Long id);
}