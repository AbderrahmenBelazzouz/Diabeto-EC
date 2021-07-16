package com.esi.rapportmedical.service;

import com.esi.rapportmedical.entity.Rapport;
import com.esi.rapportmedical.repository.RapportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RapportService {
    @Autowired
    private RapportRepository repository;

    // POST
    public Rapport saveRapport(Rapport rapport) {
        return repository.save(rapport);
    }

/*    public List<Rapport> saveRapports(List<Rapport> rapports) {
        return repository.saveAll(rapports);
    }*/

    // GET
    public List<Rapport> getRapports() {
        return repository.findAll();
    }

    public Rapport getRapportById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Rapport getRapportByTitre(String titre) {
        return repository.findByTitre(titre);
    }

    // PUT
    public Rapport updateRapport(Rapport rapport) {
        Rapport existingRapport = repository.findById(rapport.getId()).orElse(null);
        existingRapport.setTitre(rapport.getTitre());
        existingRapport.setZonetxt(rapport.getZonetxt());
        return repository.save(existingRapport);
    }

    // DELETE
    public String deleteRapport(int id) {
        repository.deleteById(id);
        return "Rapport " + id + " supprimé !! ";
    }

}
