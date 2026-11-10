package edu.altair.nuevaApiCrm.dtos;

public record ModuloRequestDto(
    String codigo,
    String diminutivo,
    String nombre,
    String descripcion,
    Integer horasSemanales,
    Integer creditos
) {}