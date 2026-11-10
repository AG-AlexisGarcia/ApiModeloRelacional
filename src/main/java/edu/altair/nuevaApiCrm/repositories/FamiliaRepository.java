package edu.altair.nuevaApiCrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.altair.nuevaApiCrm.entities.Familia;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Long> {}