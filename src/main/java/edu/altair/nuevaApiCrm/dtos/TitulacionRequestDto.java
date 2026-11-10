package edu.altair.nuevaApiCrm.dtos;

public record TitulacionRequestDto(
    String codigo,
    String diminutivo,
    Integer horasTotales
) {}
