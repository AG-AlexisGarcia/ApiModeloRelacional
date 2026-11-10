package edu.altair.nuevaApiCrm.dtos;

public record ProfesorRequestDto(
    String nombreProfesor,
    String apellidosProfesor,
    String dni,
    String emailCentroProfesor,
    String emailPersonalProfesor,
    String descripcionProfesor,
    String telefonoProfesor,
    Long idDepartamento
) {}