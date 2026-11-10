package edu.altair.nuevaApiCrm.dtos;

public record FamiliaRequestDto(
    String nombrePadre,
    String nombreMadre,
    String apellidosPadres,
    String apellidosMadres,
    String emailPadre,
    String emailMadre,
    String telefonoPadre,
    String telefonoMadre,
    String direccionPadre,
    String direccionMadre,
    String codigoPostalPadre,
    String codigoPostalMadre,
    String municipioPadre,
    String municipioMadre,
    String provinciaPadre,
    String provinciaMadre,
    Boolean sonSeparados,
    Boolean esCompartida,
    Boolean esPadre,
    Boolean esMadre
) {}