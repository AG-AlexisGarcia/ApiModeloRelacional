package edu.altair.nuevaApiCrm.dtos;

public record TitulacionResponseDto(
    Long idTitulacion,
    String codigo,
    String diminutivo,
    Integer horasTotales
) {}