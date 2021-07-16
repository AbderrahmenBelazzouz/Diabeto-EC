package com.esi.orientation.controller;

import com.esi.orientation.entity.Orientation;
import com.esi.orientation.service.OrientationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrientationController {

    @Autowired
    private OrientationService service;

    // POST
    @PostMapping("/addOrientation")
    public Orientation addOrientation(@RequestBody Orientation orientation) {
        return service.saveOrientation(orientation);
    }

/*    @PostMapping("/addOrientations")
    public List<Orientation> addOrientations(@RequestBody List<Orientation> orientations) {
        return service.saveOrientations(orientations);
    }*/

    // GET
    @GetMapping("/orientations")
    public List<Orientation> findAllOrientations() {
        return service.getOrientations();
    }

    @GetMapping("/orientationById/{id}")
    public Orientation findOrientationById(@PathVariable int id) {
        return service.getOrientationById(id);
    }

/*    @GetMapping("/orientation/{titre}")
    public Orientation findOrientationByTitre(@PathVariable String titre) {
        return service.getOrientationByTitre(titre);
    }*/

    // PUT
    @PutMapping("/update")
    public Orientation updateOrientation(@RequestBody Orientation orientation) {
        return service.updateOrientation(orientation);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteOrientation(@PathVariable int id) {
        return service.deleteOrientation(id);
    }

}
