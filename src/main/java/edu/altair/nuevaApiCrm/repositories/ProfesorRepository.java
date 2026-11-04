package edu.altair.nuevaApiCrm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.nuevaApiCrm.entities.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

	boolean existsByDni(String dni);
	
	Optional<Profesor> findByDni(String dni);
	
	
}
