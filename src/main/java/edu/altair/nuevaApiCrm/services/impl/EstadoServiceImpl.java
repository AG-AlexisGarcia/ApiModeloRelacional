package edu.altair.nuevaApiCrm.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.nuevaApiCrm.dtos.EstadoRequestDto;
import edu.altair.nuevaApiCrm.dtos.EstadoResponseDto;
import edu.altair.nuevaApiCrm.entities.Estado;
import edu.altair.nuevaApiCrm.repositories.EstadoRepository;
import edu.altair.nuevaApiCrm.services.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService {

    private final EstadoRepository estadoRepository;

    public EstadoServiceImpl(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EstadoResponseDto> obtenerTodos() {
        return estadoRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public EstadoResponseDto getById(Long id) {
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado con ID: " + id));
        return mapToResponseDto(estado);
    }

    @Override
    @Transactional
    public EstadoResponseDto crear(EstadoRequestDto requestDto) {
        Estado nuevo = new Estado();
        nuevo.setNombre(requestDto.nombre());
        nuevo.setDescripcion(requestDto.descripcion());

        Estado guardado = estadoRepository.save(nuevo);
        return mapToResponseDto(guardado);
    }

    @Override
    @Transactional
    public EstadoResponseDto actualizar(Long id, EstadoRequestDto requestDto) {
        Estado existente = estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado con ID: " + id));

        existente.setNombre(requestDto.nombre());
        existente.setDescripcion(requestDto.descripcion());

        Estado actualizado = estadoRepository.save(existente);
        return mapToResponseDto(actualizado);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!estadoRepository.existsById(id)) {
            throw new RuntimeException("Estado no encontrado con ID: " + id);
        }
        estadoRepository.deleteById(id);
    }

    private EstadoResponseDto mapToResponseDto(Estado e) {
        return new EstadoResponseDto(
                e.getIdEstado(),
                e.getNombre(),
                e.getDescripcion()
        );
    }
}