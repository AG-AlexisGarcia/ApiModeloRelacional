package edu.altair.nuevaApiCrm.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import edu.altair.nuevaApiCrm.dtos.ProfesorRequestDto;
import edu.altair.nuevaApiCrm.dtos.ProfesorResponseDto;
import edu.altair.nuevaApiCrm.repositories.ProfesorRepository;
import edu.altair.nuevaApiCrm.services.ProfesorService;

public class ProfesorServiceImpl implements ProfesorService {

	
	private final ProfesorRepository profesorRepository;
	
	public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
		this.profesorRepository = profesorRepository;
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public List<ProfesorResponseDto> obtenerTodos() {
		
		
		return profesorRepository.findAll()
				.stream()
				.map(this::mapToResponseDto)
				.toList();
	}

	@Override
	public ProfesorResponseDto crear(ProfesorRequestDto requestDto) {
		
		return null;
	}

	@Override
	public ProfesorResponseDto actualizar(Long id, ProfesorRequestDto requestDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
