package com.esi.rapportmedical.controller;

import com.esi.rapportmedical.entity.Rapport;
import com.esi.rapportmedical.service.RapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RapportController {

    @Autowired
    private RapportService service;

    // POST
    @PostMapping("/addRapport")
    public Rapport addRapport(@RequestBody Rapport rapport) {
        return service.saveRapport(rapport);
    }

/*    @PostMapping("/addRapports")
    public List<Rapport> addRapports(@RequestBody List<Rapport> rapports) {
        return service.saveRapports(rapports);
    }*/

    // GET
    @GetMapping("/rapports")
    public List<Rapport> findAllRapports() {
        return service.getRapports();
    }

    @GetMapping("/rapportById/{id}")
    public Rapport findRapportById(@PathVariable int id) {
        return service.getRapportById(id);
    }

    @GetMapping("/rapport/{titre}")
    public Rapport findRapportByTitre(@PathVariable String titre) {
        return service.getRapportByTitre(titre);
    }

    // PUT
    @PutMapping("/update")
    public Rapport updateRapport(@RequestBody Rapport rapport) {
        return service.updateRapport(rapport);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteRapport(@PathVariable int id) {
        return service.deleteRapport(id);
    }

}
