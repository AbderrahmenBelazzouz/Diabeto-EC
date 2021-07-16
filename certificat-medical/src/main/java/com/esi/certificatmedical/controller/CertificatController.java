package com.esi.certificatmedical.controller;

import com.esi.certificatmedical.entity.Certificat;
import com.esi.certificatmedical.service.CertificatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CertificatController {

    @Autowired
    private CertificatService service;

    // POST
    @PostMapping("/addCertificat")
    public Certificat addCertificat(@RequestBody Certificat certificat) {
        return service.saveCertificat(certificat);
    }

/*    @PostMapping("/addCertificats")
    public List<Certificat> addCertificats(@RequestBody List<Certificat> certificats) {
        return service.saveCertificats(certificats);
    }*/

    // GET
    @GetMapping("/certificats")
    public List<Certificat> findAllCertificats() {
        return service.getCertificats();
    }

    @GetMapping("/certificatById/{id}")
    public Certificat findCertificatById(@PathVariable int id) {
        return service.getCertificatById(id);
    }

    @GetMapping("/certificat/{titre}")
    public Certificat findCertificatByTitre(@PathVariable String titre) {
        return service.getCertificatByTitre(titre);
    }

    // PUT
    @PutMapping("/update")
    public Certificat updateCertificat(@RequestBody Certificat certificat) {
        return service.updateCertificat(certificat);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteCertificat(@PathVariable int id) {
        return service.deleteCertificat(id);
    }

}
