package com.esi.evacuation.controller;

import com.esi.evacuation.entity.Evacuation;
import com.esi.evacuation.service.EvacuationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EvacuationController {

    @Autowired
    private EvacuationService service;

    // POST
    @PostMapping("/addEvacuation")
    public Evacuation addOrientation(@RequestBody Evacuation evacuation) {
        return service.saveEvacuation(evacuation);
    }

/*    @PostMapping("/addEvacuations")
    public List<Evacuation> addEvacuations(@RequestBody List<Evacuation> evacuations) {
        return service.saveEvacuations(evacuations);
    }*/

    // GET
    @GetMapping("/evacuations")
    public List<Evacuation> findAllEvacuations() {
        return service.getEvacuations();
    }

    @GetMapping("/evacuationById/{id}")
    public Evacuation findEvacuationById(@PathVariable int id) {
        return service.getEvacuationById(id);
    }

    @GetMapping("/evacuation/{objet}")
    public Evacuation findEvacuationByObjet(@PathVariable String objet) {
        return service.getEvacuationByObjet(objet);
    }

    // PUT
    @PutMapping("/update")
    public Evacuation updateEvacuation(@RequestBody Evacuation evacuation) {
        return service.updateEvacuation(evacuation);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteEvacuation(@PathVariable int id) {
        return service.deleteEvacuation(id);
    }

}
