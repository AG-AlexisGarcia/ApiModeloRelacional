package edu.altair.nuevaApiCrm.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.nuevaApiCrm.dtos.AlumnoRequestDto;
import edu.altair.nuevaApiCrm.dtos.AlumnoResponseDto;
import edu.altair.nuevaApiCrm.entities.Alumno;
import edu.altair.nuevaApiCrm.repositories.AlumnoRepository;
import edu.altair.nuevaApiCrm.services.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AlumnoResponseDto> obtenerTodos() {
        return alumnoRepository.findAll().stream().map(this::mapToDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public AlumnoResponseDto getById(Long id) {
        Alumno a = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con ID: " + id));
        return mapToDto(a);
    }

    @Override
    @Transactional
    public AlumnoResponseDto crear(AlumnoRequestDto dto) {
        Alumno a = new Alumno();
        copiarDatos(a, dto);
        return mapToDto(alumnoRepository.save(a));
    }

    @Override
    @Transactional
    public AlumnoResponseDto actualizar(Long id, AlumnoRequestDto dto) {
        Alumno a = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con ID: " + id));
        copiarDatos(a, dto);
        return mapToDto(alumnoRepository.save(a));
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!alumnoRepository.existsById(id)) {
            throw new RuntimeException("Alumno no encontrado con ID: " + id);
        }
        alumnoRepository.deleteById(id);
    }

    private void copiarDatos(Alumno a, AlumnoRequestDto dto) {
        a.setNombre(dto.nombre());
        a.setApellidos(dto.apellidos());
        a.setDni(dto.dni());
        a.setNumeroSs(dto.numeroSs());
        a.setEmailPersonal(dto.emailPersonal());
        a.setTelefonoPersonal(dto.telefonoPersonal());
        a.setFechaAlta(dto.fechaAlta());
        a.setFechaBaja(dto.fechaBaja());
        a.setEmailCentro(dto.emailCentro());
    }

    private AlumnoResponseDto mapToDto(Alumno a) {
        return new AlumnoResponseDto(
            a.getIdAlumno(), a.getNombre(), a.getApellidos(), a.getDni(),
            a.getNumeroSs(), a.getEmailPersonal(), a.getTelefonoPersonal(),
            a.getFechaAlta(), a.getFechaBaja(), a.getEmailCentro()
        );
    }
}