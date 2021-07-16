package com.esi.examenclinique.controllers;

import com.esi.examenclinique.entities.ExamenClinique;
import com.esi.examenclinique.services.ExamenCliniqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamenCliniqueController {

    @Autowired
    private ExamenCliniqueService examenCliniqueService;

    @PostMapping("/addEC")
    public ExamenClinique addExamenClinique(@RequestBody ExamenClinique examenClinique){
        return examenCliniqueService.saveExamenClinique(examenClinique);
    }
    @PostMapping("/addECs")
    public List<ExamenClinique> addExamensCliniques(@RequestBody List<ExamenClinique> examensCliniques){
        return examenCliniqueService.saveExamensCliniques(examensCliniques);
    }

    @GetMapping("/ECs")
    public List<ExamenClinique> getExamensCliniques(){
        return examenCliniqueService.getExamensCliniques();
    }

    @GetMapping("/EC/{id}")
    public ExamenClinique getExamenCliniqueById(@PathVariable(name = "id") Long idEC){
        return examenCliniqueService.getExamenCliniqueById(idEC);
    }

    @PutMapping("/updateEC")
    public ExamenClinique updateExamenClinique(@RequestBody ExamenClinique examenClinique){

        return examenCliniqueService.updateExamenClinique(examenClinique);
    }

    @DeleteMapping("/deleteEC/{id}")
    public String deleteExamenClinique(@PathVariable(name = "id") Long idEC){
        return examenCliniqueService.deleteExamenClinique(idEC);
    }
}
