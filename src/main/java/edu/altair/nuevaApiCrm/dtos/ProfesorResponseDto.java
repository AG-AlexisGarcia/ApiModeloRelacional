package edu.altair.nuevaApiCrm.dtos;

public record ProfesorResponseDto(
    Long idProfesor,
    String nombreProfesor,
    String apellidosProfesor,
    String dni,
    String emailCentroProfesor,
    String emailPersonalProfesor,
    String descripcionProfesor,
    String telefonoProfesor
) {}


