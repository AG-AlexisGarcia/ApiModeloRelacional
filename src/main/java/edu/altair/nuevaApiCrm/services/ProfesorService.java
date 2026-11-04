package edu.altair.apicrm.services;

import java.util.List;

import edu.altair.nuevaApiCrm.dtos.ProfesorRequestDto;
import edu.altair.nuevaApiCrm.dtos.ProfesorResponseDto;

public interface ProfesorService {
    List<ProfesorResponseDto> obtenerTodos();
    ProfesorResponseDto crear(ProfesorRequestDto requestDto);
    ProfesorResponseDto actualizar(Long id, ProfesorRequestDto requestDto);
    void eliminar(Long id);
}
