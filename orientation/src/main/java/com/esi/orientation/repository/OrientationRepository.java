package com.esi.orientation.repository;

import com.esi.orientation.entity.Orientation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrientationRepository extends JpaRepository<Orientation,Integer> {
    // Orientation findByTitre(String titre);
}
