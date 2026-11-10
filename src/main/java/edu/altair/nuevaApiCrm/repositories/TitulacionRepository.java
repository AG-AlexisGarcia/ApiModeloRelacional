package edu.altair.nuevaApiCrm.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.altair.nuevaApiCrm.entities.Titulacion;

@Repository
public interface TitulacionRepository extends JpaRepository<Titulacion, Long> {
    boolean existsByCodigo(String codigo);
    boolean existsByDiminutivo(String diminutivo);
    Optional<Titulacion> findByCodigo(String codigo);
}