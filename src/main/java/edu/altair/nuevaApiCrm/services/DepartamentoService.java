package edu.altair.nuevaApiCrm.services;

import java.util.List;
import edu.altair.nuevaApiCrm.dtos.DepartamentoRequestDto;
import edu.altair.nuevaApiCrm.dtos.DepartamentoResponseDto;

public interface DepartamentoService {
    List<DepartamentoResponseDto> obtenerTodos();
    DepartamentoResponseDto getById(Long id);
    DepartamentoResponseDto crear(DepartamentoRequestDto requestDto);
    DepartamentoResponseDto actualizar(Long id, DepartamentoRequestDto requestDto);
    void eliminar(Long id);
}
