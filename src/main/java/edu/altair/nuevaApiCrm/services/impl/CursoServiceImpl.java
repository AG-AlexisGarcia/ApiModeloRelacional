package edu.altair.nuevaApiCrm.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.nuevaApiCrm.dtos.CursoRequestDto;
import edu.altair.nuevaApiCrm.dtos.CursoResponseDto;
import edu.altair.nuevaApiCrm.entities.Curso;
import edu.altair.nuevaApiCrm.repositories.CursoRepository;
import edu.altair.nuevaApiCrm.services.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CursoResponseDto> obtenerTodos() {
        return cursoRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CursoResponseDto getById(Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));
        return mapToResponseDto(curso);
    }

    @Override
    @Transactional
    public CursoResponseDto crear(CursoRequestDto requestDto) {
        Curso nuevo = new Curso();
        nuevo.setDiminutivo(requestDto.diminutivo());
        nuevo.setDescripcion(requestDto.descripcion());

        Curso guardado = cursoRepository.save(nuevo);
        return mapToResponseDto(guardado);
    }

    @Override
    @Transactional
    public CursoResponseDto actualizar(Long id, CursoRequestDto requestDto) {
        Curso existente = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));

        existente.setDiminutivo(requestDto.diminutivo());
        existente.setDescripcion(requestDto.descripcion());

        Curso actualizado = cursoRepository.save(existente);
        return mapToResponseDto(actualizado);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!cursoRepository.existsById(id)) {
            throw new RuntimeException("Curso no encontrado con ID: " + id);
        }
        cursoRepository.deleteById(id);
    }

    private CursoResponseDto mapToResponseDto(Curso c) {
        return new CursoResponseDto(
                c.getIdCurso(),
                c.getDiminutivo(),
                c.getDescripcion()
        );
    }
}
