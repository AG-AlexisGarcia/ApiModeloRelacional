package edu.altair.nuevaApiCrm.dtos;

import edu.altair.nuevaApiCrm.entities.Departamento;

public record ProfesorResponseDto(
		long idProfesor, 
		String nombreProfesor, 
		String apellidosProfesor, 
		String dniProfesor,
		String emailCentroProfesor, 
		String emailPerosnalProfesor, 
		String descripcionProfesor,
		String telefonoProfesor,
		Departamento departamento
) {}


