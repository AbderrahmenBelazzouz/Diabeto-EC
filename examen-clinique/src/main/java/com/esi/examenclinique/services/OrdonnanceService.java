package com.esi.examenclinique.services;

import com.esi.examenclinique.entities.ExamenClinique;
import com.esi.examenclinique.entities.Ordonnance;
import com.esi.examenclinique.repositories.ExamenCliniqueRepository;
import com.esi.examenclinique.repositories.OrdonnanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdonnanceService {

    @Autowired
    private OrdonnanceRepository ordonnanceRepository;
    @Autowired
    private ExamenCliniqueRepository examenCliniqueRepository;

    public ExamenClinique getEMById(Long idEM){
        return examenCliniqueRepository.findById(idEM).orElse(null);
    }

    //post methods
    public Ordonnance saveOrdonnance(Ordonnance ordonnance){

        // Set child reference(ordonnance) in parent entity(EM)
        ExamenClinique em =  getEMById(ordonnance.getId());
        // Set parent reference(EM) in child entity(ordonnance)
        ordonnance.setExamenClinique(em);
        em.setOrdonnance(ordonnance);
        // Save Parent Reference (which will save the child as well)
        examenCliniqueRepository.save(em);
        return ordonnanceRepository.save(ordonnance);

    }

    public List<Ordonnance> saveOrdonnances(List<Ordonnance> ordonnances){
        return ordonnanceRepository.saveAll(ordonnances);
    }

    //get methods
    public List<Ordonnance> getOrdonnances(){
        return ordonnanceRepository.findAll();
    }

    public Ordonnance getOrdonnanceById(Long idEM){
        return ordonnanceRepository.findById(idEM).orElse(null);
    }

    //delete method
    public String deleteOrdonnance(Long idOrd){
        ExamenClinique em =  getEMById(idOrd);
        em.setOrdonnance(null);
        ordonnanceRepository.deleteById(idOrd);
        return "Ordonnance Removed "+idOrd;
    }

    //update method
    public Ordonnance updateOrdonnance(Ordonnance ordonnance){
        Ordonnance exsistingOrd = ordonnanceRepository.findById(ordonnance.getId()).orElse(null);
        exsistingOrd.setLente(ordonnance.getLente());
        exsistingOrd.setRapide(ordonnance.getRapide());
        exsistingOrd.setEpaisseure(ordonnance.getEpaisseure());
        exsistingOrd.setAiguillesJ(ordonnance.getAiguillesJ());
        exsistingOrd.setBandelettesJ(ordonnance.getBandelettesJ());
        exsistingOrd.setLancettesJ(ordonnance.getLancettesJ());
        exsistingOrd.setAutre(ordonnance.getAutre());
        exsistingOrd.setExamenClinique(ordonnance.getExamenClinique());

        return ordonnanceRepository.save(exsistingOrd);
    }
}
