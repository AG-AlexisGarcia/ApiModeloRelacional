package edu.altair.nuevaApiCrm.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.nuevaApiCrm.dtos.DepartamentoRequestDto;
import edu.altair.nuevaApiCrm.dtos.DepartamentoResponseDto;
import edu.altair.nuevaApiCrm.entities.Departamento;
import edu.altair.nuevaApiCrm.repositories.DepartamentoRepository;
import edu.altair.nuevaApiCrm.services.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DepartamentoResponseDto> obtenerTodos() {
        return departamentoRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public DepartamentoResponseDto getById(Long id) {
        Departamento dep = departamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado con ID: " + id));
        return mapToResponseDto(dep);
    }

    @Override
    @Transactional
    public DepartamentoResponseDto crear(DepartamentoRequestDto requestDto) {
        Departamento nuevo = new Departamento();
        nuevo.setCodigo(requestDto.codigo());
        nuevo.setNombre(requestDto.nombre());
        Departamento guardado = departamentoRepository.save(nuevo);
        return mapToResponseDto(guardado);
    }

    @Override
    @Transactional
    public DepartamentoResponseDto actualizar(Long id, DepartamentoRequestDto requestDto) {
        Departamento dep = departamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado con ID: " + id));
        dep.setCodigo(requestDto.codigo());
        dep.setNombre(requestDto.nombre());
        Departamento actualizado = departamentoRepository.save(dep);
        return mapToResponseDto(actualizado);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!departamentoRepository.existsById(id)) {
            throw new RuntimeException("Departamento no encontrado con ID: " + id);
        }
        departamentoRepository.deleteById(id);
    }

    private DepartamentoResponseDto mapToResponseDto(Departamento d) {
        return new DepartamentoResponseDto(
                d.getIdDepartamento(),
                d.getCodigo(),
                d.getNombre()
        );
    }
}