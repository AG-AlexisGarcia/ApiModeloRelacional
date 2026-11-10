package edu.altair.nuevaApiCrm.dtos;

import edu.altair.nuevaApiCrm.entities.Departamento;

public record ProfesorRequestDto(
		Long idProfesor, 
		String nombreProfesor, 
		String apellidosProfesor, 
		String dni,
		String emailCentroProfesor, 
		String emailPersonalProfesor, 
		String descripcionProfesor,
		String telefonoProfesor,
		Departamento departamento
) {}


