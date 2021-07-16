package com.esi.orientation.service;

import com.esi.orientation.entity.Orientation;
import com.esi.orientation.repository.OrientationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrientationService {
    @Autowired
    private OrientationRepository repository;

    // POST
    public Orientation saveOrientation(Orientation orientation) {
        return repository.save(orientation);
    }

/*    public List<Orientation> saveOrientations(List<Orientation> orientations) {
        return repository.saveAll(orientations);
    }*/

    // GET
    public List<Orientation> getOrientations() {
        return repository.findAll();
    }

    public Orientation getOrientationById(int id) {
        return repository.findById(id).orElse(null);
    }

/*    public Orientation getOrientationByTitre(String titre) {
        return repository.findByTitre(titre);
    }*/

    // PUT
    public Orientation updateOrientation(Orientation orientation) {
        Orientation existingOrientation = repository.findById(orientation.getId()).orElse(null);
        // existingOrientation.setTitre(orientation.getTitre());
        existingOrientation.setZonetxt(orientation.getZonetxt());
        return repository.save(existingOrientation);
    }

    // DELETE
    public String deleteOrientation(int id) {
        repository.deleteById(id);
        return "Orientation " + id + " supprimé !! ";
    }

}
