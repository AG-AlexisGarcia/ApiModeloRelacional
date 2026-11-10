package edu.altair.nuevaApiCrm.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.nuevaApiCrm.dtos.DepartamentoResponseDto;
import edu.altair.nuevaApiCrm.dtos.ProfesorRequestDto;
import edu.altair.nuevaApiCrm.dtos.ProfesorResponseDto;
import edu.altair.nuevaApiCrm.entities.Departamento;
import edu.altair.nuevaApiCrm.entities.Profesor;
import edu.altair.nuevaApiCrm.repositories.DepartamentoRepository;
import edu.altair.nuevaApiCrm.repositories.ProfesorRepository;
import edu.altair.nuevaApiCrm.services.ProfesorService;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;
    private final DepartamentoRepository departamentoRepository;

    public ProfesorServiceImpl(ProfesorRepository profesorRepository, DepartamentoRepository departamentoRepository) {
        this.profesorRepository = profesorRepository;
        this.departamentoRepository = departamentoRepository;
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
        mapearCampos(nuevoProfesor, requestDto);

        Profesor guardado = profesorRepository.save(nuevoProfesor);
        return mapToResponseDto(guardado);
    }

    @Override
    @Transactional
    public ProfesorResponseDto actualizar(Long id, ProfesorRequestDto requestDto) {
        Profesor profesorExistente = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con ID: " + id));

        mapearCampos(profesorExistente, requestDto);

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

    private void mapearCampos(Profesor p, ProfesorRequestDto dto) {
        p.setNombreProfesor(dto.nombreProfesor());
        p.setApellidosProfesor(dto.apellidosProfesor());
        p.setDni(dto.dni());
        p.setEmailCentroProfesor(dto.emailCentroProfesor());
        p.setEmailPersonalProfesor(dto.emailPersonalProfesor());
        p.setTelefonoProfesor(dto.telefonoProfesor());
        p.setDescripcionProfesor(dto.descripcionProfesor());

        if (dto.idDepartamento() != null) {
            Departamento dep = departamentoRepository.findById(dto.idDepartamento())
                    .orElse(null);
            p.setDepartamento(dep);
        } else {
            p.setDepartamento(null);
        }
    }

    private ProfesorResponseDto mapToResponseDto(Profesor profesor) {
        DepartamentoResponseDto depDto = null;
        if (profesor.getDepartamento() != null) {
            depDto = new DepartamentoResponseDto(
                    profesor.getDepartamento().getIdDepartamento(),
                    profesor.getDepartamento().getCodigo(),
                    profesor.getDepartamento().getNombre()
            );
        }

        return new ProfesorResponseDto(
                profesor.getIdProfesor(),
                profesor.getNombreProfesor(),
                profesor.getApellidosProfesor(),
                profesor.getDni(),
                profesor.getEmailCentroProfesor(),
                profesor.getEmailPersonalProfesor(),
                profesor.getDescripcionProfesor(),
                profesor.getTelefonoProfesor(),
                depDto
        );
    }
}