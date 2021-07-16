package com.esi.evacuation.repository;

import com.esi.evacuation.entity.Evacuation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvacuationRepository extends JpaRepository<Evacuation,Integer> {
    Evacuation findByObjet(String objet);
}
