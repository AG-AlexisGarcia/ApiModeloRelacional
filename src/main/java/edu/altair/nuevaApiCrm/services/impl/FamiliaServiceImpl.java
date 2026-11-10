package edu.altair.nuevaApiCrm.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.nuevaApiCrm.dtos.FamiliaRequestDto;
import edu.altair.nuevaApiCrm.dtos.FamiliaResponseDto;
import edu.altair.nuevaApiCrm.entities.Familia;
import edu.altair.nuevaApiCrm.repositories.FamiliaRepository;
import edu.altair.nuevaApiCrm.services.FamiliaService;

@Service
public class FamiliaServiceImpl implements FamiliaService {

    private final FamiliaRepository familiaRepository;

    public FamiliaServiceImpl(FamiliaRepository familiaRepository) {
        this.familiaRepository = familiaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<FamiliaResponseDto> obtenerTodos() {
        return familiaRepository.findAll().stream().map(this::mapToDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public FamiliaResponseDto getById(Long id) {
        Familia fam = familiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Familia no encontrada con ID: " + id));
        return mapToDto(fam);
    }

    @Override
    @Transactional
    public FamiliaResponseDto crear(FamiliaRequestDto dto) {
        Familia f = new Familia();
        copiarDatos(f, dto);
        return mapToDto(familiaRepository.save(f));
    }

    @Override
    @Transactional
    public FamiliaResponseDto actualizar(Long id, FamiliaRequestDto dto) {
        Familia f = familiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Familia no encontrada con ID: " + id));
        copiarDatos(f, dto);
        return mapToDto(familiaRepository.save(f));
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!familiaRepository.existsById(id)) {
            throw new RuntimeException("Familia no encontrada con ID: " + id);
        }
        familiaRepository.deleteById(id);
    }

    private void copiarDatos(Familia f, FamiliaRequestDto dto) {
        f.setNombrePadre(dto.nombrePadre());
        f.setNombreMadre(dto.nombreMadre());
        f.setApellidosPadres(dto.apellidosPadres());
        f.setApellidosMadres(dto.apellidosMadres());
        f.setEmailPadre(dto.emailPadre());
        f.setEmailMadre(dto.emailMadre());
        f.setTelefonoPadre(dto.telefonoPadre());
        f.setTelefonoMadre(dto.telefonoMadre());
        f.setDireccionPadre(dto.direccionPadre());
        f.setDireccionMadre(dto.direccionMadre());
        f.setCodigoPostalPadre(dto.codigoPostalPadre());
        f.setCodigoPostalMadre(dto.codigoPostalMadre());
        f.setMunicipioPadre(dto.municipioPadre());
        f.setMunicipioMadre(dto.municipioMadre());
        f.setProvinciaPadre(dto.provinciaPadre());
        f.setProvinciaMadre(dto.provinciaMadre());
        f.setSonSeparados(dto.sonSeparados());
        f.setEsCompartida(dto.esCompartida());
        f.setEsPadre(dto.esPadre());
        f.setEsMadre(dto.esMadre());
    }

    private FamiliaResponseDto mapToDto(Familia f) {
        return new FamiliaResponseDto(
            f.getIdFamilia(), f.getNombrePadre(), f.getNombreMadre(), f.getApellidosPadres(),
            f.getApellidosMadres(), f.getEmailPadre(), f.getEmailMadre(), f.getTelefonoPadre(),
            f.getTelefonoMadre(), f.getDireccionPadre(), f.getDireccionMadre(), f.getCodigoPostalPadre(),
            f.getCodigoPostalMadre(), f.getMunicipioPadre(), f.getMunicipioMadre(), f.getProvinciaPadre(),
            f.getProvinciaMadre(), f.getSonSeparados(), f.getEsCompartida(), f.getEsPadre(), f.getEsMadre()
        );
    }
}