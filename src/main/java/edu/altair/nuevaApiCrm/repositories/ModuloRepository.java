package edu.altair.nuevaApiCrm.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.altair.nuevaApiCrm.entities.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long> {
    boolean existsByCodigo(String codigo);
    boolean existsByDiminutivo(String diminutivo);
    Optional<Modulo> findByCodigo(String codigo);
}