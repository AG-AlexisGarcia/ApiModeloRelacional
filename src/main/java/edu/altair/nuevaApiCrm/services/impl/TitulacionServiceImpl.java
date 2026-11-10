package edu.altair.nuevaApiCrm.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.nuevaApiCrm.dtos.TitulacionRequestDto;
import edu.altair.nuevaApiCrm.dtos.TitulacionResponseDto;
import edu.altair.nuevaApiCrm.entities.Titulacion;
import edu.altair.nuevaApiCrm.repositories.TitulacionRepository;
import edu.altair.nuevaApiCrm.services.TitulacionService;

@Service
public class TitulacionServiceImpl implements TitulacionService {

    private final TitulacionRepository titulacionRepository;

    public TitulacionServiceImpl(TitulacionRepository titulacionRepository) {
        this.titulacionRepository = titulacionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TitulacionResponseDto> obtenerTodos() {
        return titulacionRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public TitulacionResponseDto getById(Long id) {
        Titulacion tit = titulacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Titulación no encontrada con ID: " + id));
        return mapToResponseDto(tit);
    }

    @Override
    @Transactional
    public TitulacionResponseDto crear(TitulacionRequestDto requestDto) {
        Titulacion nueva = new Titulacion();
        nueva.setCodigo(requestDto.codigo());
        nueva.setDiminutivo(requestDto.diminutivo());
        nueva.setHorasTotales(requestDto.horasTotales());

        Titulacion guardada = titulacionRepository.save(nueva);
        return mapToResponseDto(guardada);
    }

    @Override
    @Transactional
    public TitulacionResponseDto actualizar(Long id, TitulacionRequestDto requestDto) {
        Titulacion existente = titulacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Titulación no encontrada con ID: " + id));

        existente.setCodigo(requestDto.codigo());
        existente.setDiminutivo(requestDto.diminutivo());
        existente.setHorasTotales(requestDto.horasTotales());

        Titulacion actualizada = titulacionRepository.save(existente);
        return mapToResponseDto(actualizada);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!titulacionRepository.existsById(id)) {
            throw new RuntimeException("Titulación no encontrada con ID: " + id);
        }
        titulacionRepository.deleteById(id);
    }

    private TitulacionResponseDto mapToResponseDto(Titulacion t) {
        return new TitulacionResponseDto(
                t.getIdTitulacion(),
                t.getCodigo(),
                t.getDiminutivo(),
                t.getHorasTotales()
        );
    }
}