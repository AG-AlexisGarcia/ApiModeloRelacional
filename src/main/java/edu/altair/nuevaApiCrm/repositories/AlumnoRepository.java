package edu.altair.nuevaApiCrm.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.altair.nuevaApiCrm.entities.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    boolean existsByDni(String dni);
    Optional<Alumno> findByDni(String dni);
}