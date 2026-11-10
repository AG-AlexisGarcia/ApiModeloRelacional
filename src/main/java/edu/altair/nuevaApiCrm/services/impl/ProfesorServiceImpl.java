package edu.altair.nuevaApiCrm.services.impl; // Ajusta a tu paquete real

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.nuevaApiCrm.dtos.ProfesorRequestDto;
import edu.altair.nuevaApiCrm.dtos.ProfesorResponseDto;
import edu.altair.nuevaApiCrm.entities.Profesor;
import edu.altair.nuevaApiCrm.repositories.ProfesorRepository;
import edu.altair.nuevaApiCrm.services.ProfesorService;

@Service
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
    @Transactional(readOnly = true)
    public ProfesorResponseDto getById(Long id) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con ID: " + id));
        return mapToResponseDto(profesor);
    }

    @Override
    @Transactional
    public ProfesorResponseDto crear(ProfesorRequestDto requestDto) {
        Profesor nuevoProfesor = new Profesor();
        nuevoProfesor.setNombreProfesor(requestDto.nombreProfesor());
        nuevoProfesor.setApellidosProfesor(requestDto.apellidosProfesor());
        nuevoProfesor.setDni(requestDto.dni());
        nuevoProfesor.setEmailCentroProfesor(requestDto.emailCentroProfesor());
        nuevoProfesor.setEmailPersonalProfesor(requestDto.emailPersonalProfesor());
        nuevoProfesor.setTelefonoProfesor(requestDto.telefonoProfesor());
        nuevoProfesor.setDescripcionProfesor(requestDto.descripcionProfesor());

        Profesor guardado = profesorRepository.save(nuevoProfesor);
        return mapToResponseDto(guardado);
    }

    @Override
    @Transactional
    public ProfesorResponseDto actualizar(Long id, ProfesorRequestDto requestDto) {
        Profesor profesorExistente = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con ID: " + id));

        profesorExistente.setNombreProfesor(requestDto.nombreProfesor());
        profesorExistente.setApellidosProfesor(requestDto.apellidosProfesor());
        profesorExistente.setDni(requestDto.dni());
        profesorExistente.setEmailCentroProfesor(requestDto.emailCentroProfesor());
        profesorExistente.setEmailPersonalProfesor(requestDto.emailPersonalProfesor());
        profesorExistente.setTelefonoProfesor(requestDto.telefonoProfesor());
        profesorExistente.setDescripcionProfesor(requestDto.descripcionProfesor());

        Profesor actualizado = profesorRepository.save(profesorExistente);
        return mapToResponseDto(actualizado);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!profesorRepository.existsById(id)) {
            throw new RuntimeException("Profesor no encontrado con ID: " + id);
        }
        profesorRepository.deleteById(id);
    }

    // Método privado de mapeo Entity -> DTO
    private ProfesorResponseDto mapToResponseDto(Profesor profesor) {
        return new ProfesorResponseDto(
                profesor.getIdProfesor(),
                profesor.getNombreProfesor(),
                profesor.getApellidosProfesor(),
                profesor.getDni(),
                profesor.getEmailCentroProfesor(),
                profesor.getEmailPersonalProfesor(),
                profesor.getDescripcionProfesor(),
                profesor.getTelefonoProfesor()
        );
    }
}