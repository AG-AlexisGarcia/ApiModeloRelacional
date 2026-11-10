package edu.altair.nuevaApiCrm.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.altair.nuevaApiCrm.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    boolean existsByDiminutivo(String diminutivo);
    Optional<Curso> findByDiminutivo(String diminutivo);
}