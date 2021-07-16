package com.esi.evacuation.service;

import com.esi.evacuation.entity.Evacuation;
import com.esi.evacuation.repository.EvacuationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvacuationService {
    @Autowired
    private EvacuationRepository repository;

    // POST
    public Evacuation saveEvacuation(Evacuation evacuation) {
        return repository.save(evacuation);
    }

/*    public List<Evacuation> saveEvacuations(List<Evacuation> evacuations) {
        return repository.saveAll(evacuations);
    }*/

    // GET
    public List<Evacuation> getEvacuations() {
        return repository.findAll();
    }

    public Evacuation getEvacuationById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Evacuation getEvacuationByObjet(String objet) {
        return repository.findByObjet(objet);
    }

    // PUT
    public Evacuation updateEvacuation(Evacuation evacuation) {
        Evacuation existingEvacuation = repository.findById(evacuation.getId()).orElse(null);
        existingEvacuation.setObjet(evacuation.getObjet());
        existingEvacuation.setZonetxt(evacuation.getZonetxt());
        return repository.save(existingEvacuation);
    }

    // DELETE
    public String deleteEvacuation(int id) {
        repository.deleteById(id);
        return "Evacuation " + id + " supprimé !! ";
    }

}
