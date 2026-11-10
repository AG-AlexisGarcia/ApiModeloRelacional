package edu.altair.nuevaApiCrm.services;

import java.util.List;
import edu.altair.nuevaApiCrm.dtos.TitulacionRequestDto;
import edu.altair.nuevaApiCrm.dtos.TitulacionResponseDto;

public interface TitulacionService {
    List<TitulacionResponseDto> obtenerTodos();
    TitulacionResponseDto getById(Long id);
    TitulacionResponseDto crear(TitulacionRequestDto requestDto);
    TitulacionResponseDto actualizar(Long id, TitulacionRequestDto requestDto);
    void eliminar(Long id);
}
