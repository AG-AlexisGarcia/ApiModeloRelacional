package edu.altair.nuevaApiCrm.services;

import java.util.List;
import edu.altair.nuevaApiCrm.dtos.ModuloRequestDto;
import edu.altair.nuevaApiCrm.dtos.ModuloResponseDto;

public interface ModuloService {
    List<ModuloResponseDto> obtenerTodos();
    ModuloResponseDto getById(Long id);
    ModuloResponseDto crear(ModuloRequestDto requestDto);
    ModuloResponseDto actualizar(Long id, ModuloRequestDto requestDto);
    void eliminar(Long id);
}