package com.esi.certificatmedical.repository;

import com.esi.certificatmedical.entity.Certificat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificatRepository extends JpaRepository<Certificat,Integer> {
    Certificat findByTitre(String titre);
}
