package com.esi.rapportmedical.repository;

import com.esi.rapportmedical.entity.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RapportRepository extends JpaRepository<Rapport,Integer> {
    Rapport findByTitre(String titre);
}
