package edu.altair.nuevaApiCrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.altair.nuevaApiCrm.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    boolean existsByNombre(String nombre);
}