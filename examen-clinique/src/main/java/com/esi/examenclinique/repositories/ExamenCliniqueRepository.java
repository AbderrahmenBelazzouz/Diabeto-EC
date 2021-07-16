package com.esi.examenclinique.repositories;

import com.esi.examenclinique.entities.ExamenClinique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExamenCliniqueRepository extends JpaRepository<ExamenClinique, Long> {
}
