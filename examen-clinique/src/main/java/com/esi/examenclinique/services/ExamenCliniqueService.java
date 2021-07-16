package com.esi.examenclinique.services;

import com.esi.examenclinique.entities.ExamenClinique;
import com.esi.examenclinique.repositories.ExamenCliniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenCliniqueService {

    @Autowired
    private ExamenCliniqueRepository examenCliniqueRepository;

    //post methods
    public ExamenClinique saveExamenClinique(ExamenClinique examenMedical){
        return examenCliniqueRepository.save(examenMedical);
    }

    public List<ExamenClinique> saveExamensCliniques(List<ExamenClinique> examensCliniques){
        return examenCliniqueRepository.saveAll(examensCliniques);
    }

    //get methods
    public List<ExamenClinique> getExamensCliniques(){
        return examenCliniqueRepository.findAll();
    }

    public ExamenClinique getExamenCliniqueById(Long idEM){
        return examenCliniqueRepository.findById(idEM).orElse(null);
    }

    //delete method
    public String deleteExamenClinique(Long idEM){
        examenCliniqueRepository.deleteById(idEM);
        return "Examen Clinique Removed "+idEM;
    }

    //update method
    public ExamenClinique updateExamenClinique(ExamenClinique examenClinique){
        ExamenClinique exsistingEC = examenCliniqueRepository.findById(examenClinique.getId()).orElse(null);
        exsistingEC.setOrdonnance(examenClinique.getOrdonnance());
        return examenCliniqueRepository.save(exsistingEC);
    }
}
