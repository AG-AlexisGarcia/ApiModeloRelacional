package edu.altair.nuevaApiCrm.services;

import java.util.List;
import edu.altair.nuevaApiCrm.dtos.AlumnoRequestDto;
import edu.altair.nuevaApiCrm.dtos.AlumnoResponseDto;

public interface AlumnoService {
    List<AlumnoResponseDto> obtenerTodos();
    AlumnoResponseDto getById(Long id);
    AlumnoResponseDto crear(AlumnoRequestDto requestDto);
    AlumnoResponseDto actualizar(Long id, AlumnoRequestDto requestDto);
    void eliminar(Long id);
}