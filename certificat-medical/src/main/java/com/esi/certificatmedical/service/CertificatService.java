package com.esi.certificatmedical.service;

import com.esi.certificatmedical.entity.Certificat;
import com.esi.certificatmedical.repository.CertificatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificatService {
    @Autowired
    private CertificatRepository repository;

    // POST
    public Certificat saveCertificat(Certificat certificat) {
        return repository.save(certificat);
    }

/*    public List<Certificat> saveCertificats(List<Certificat> certificats) {
        return repository.saveAll(certificats);
    }*/

    // GET
    public List<Certificat> getCertificats() {
        return repository.findAll();
    }

    public Certificat getCertificatById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Certificat getCertificatByTitre(String titre) {
        return repository.findByTitre(titre);
    }

    // PUT
    public Certificat updateCertificat(Certificat certificat) {
        Certificat existingCertificat = repository.findById(certificat.getId()).orElse(null);
        existingCertificat.setTitre(certificat.getTitre());
        existingCertificat.setZonetxt(certificat.getZonetxt());
        return repository.save(existingCertificat);
    }

    // DELETE
    public String deleteCertificat(int id) {
        repository.deleteById(id);
        return "Certificat " + id + " supprimé !! ";
    }

}
