package edu.altair.nuevaApiCrm.dtos;

import java.time.LocalDate;

public record AlumnoRequestDto(
    String nombre,
    String apellidos,
    String dni,
    String numeroSs,
    String emailPersonal,
    String telefonoPersonal,
    LocalDate fechaAlta,
    LocalDate fechaBaja,
    String emailCentro
) {}