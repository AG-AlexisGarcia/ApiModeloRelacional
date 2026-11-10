package edu.altair.nuevaApiCrm.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.nuevaApiCrm.dtos.ModuloRequestDto;
import edu.altair.nuevaApiCrm.dtos.ModuloResponseDto;
import edu.altair.nuevaApiCrm.entities.Modulo;
import edu.altair.nuevaApiCrm.repositories.ModuloRepository;
import edu.altair.nuevaApiCrm.services.ModuloService;

@Service
public class ModuloServiceImpl implements ModuloService {

    private final ModuloRepository moduloRepository;

    public ModuloServiceImpl(ModuloRepository moduloRepository) {
        this.moduloRepository = moduloRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ModuloResponseDto> obtenerTodos() {
        return moduloRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ModuloResponseDto getById(Long id) {
        Modulo modulo = moduloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Módulo no encontrado con ID: " + id));
        return mapToResponseDto(modulo);
    }

    @Override
    @Transactional
    public ModuloResponseDto crear(ModuloRequestDto requestDto) {
        Modulo nuevo = new Modulo();
        nuevo.setCodigo(requestDto.codigo());
        nuevo.setDiminutivo(requestDto.diminutivo());
        nuevo.setNombre(requestDto.nombre());
        nuevo.setDescripcion(requestDto.descripcion());
        nuevo.setHorasSemanales(requestDto.horasSemanales());
        nuevo.setCreditos(requestDto.creditos());

        Modulo guardado = moduloRepository.save(nuevo);
        return mapToResponseDto(guardado);
    }

    @Override
    @Transactional
    public ModuloResponseDto actualizar(Long id, ModuloRequestDto requestDto) {
        Modulo existente = moduloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Módulo no encontrado con ID: " + id));

        existente.setCodigo(requestDto.codigo());
        existente.setDiminutivo(requestDto.diminutivo());
        existente.setNombre(requestDto.nombre());
        existente.setDescripcion(requestDto.descripcion());
        existente.setHorasSemanales(requestDto.horasSemanales());
        existente.setCreditos(requestDto.creditos());

        Modulo actualizado = moduloRepository.save(existente);
        return mapToResponseDto(actualizado);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!moduloRepository.existsById(id)) {
            throw new RuntimeException("Módulo no encontrado con ID: " + id);
        }
        moduloRepository.deleteById(id);
    }

    private ModuloResponseDto mapToResponseDto(Modulo m) {
        return new ModuloResponseDto(
                m.getIdModulo(),
                m.getCodigo(),
                m.getDiminutivo(),
                m.getNombre(),
                m.getDescripcion(),
                m.getHorasSemanales(),
                m.getCreditos()
        );
    }
}