package com.groupeisi.web.rest;

import com.groupeisi.service.EtudiantService;
import com.groupeisi.service.dto.EtudiantDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1")
public class EtudiantController {

    private final EtudiantService etudiantService;
    Logger logger = Logger.getLogger(EtudiantController.class.getName());

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping("/etudiants")
    public List<EtudiantDTO> getAllEtudiants() {
        logger.log(Level.WARNING, "REST request to get all Etudiants");
        return etudiantService.findAll();
    }

    @GetMapping("/etudiant/{id}")
    public ResponseEntity<EtudiantDTO> getEtudiantById(@PathVariable Long id) {
        logger.log(Level.WARNING, "REST request to get Etudiant by id");
        return ResponseEntity.ok(etudiantService.findById(id));
    }

    @PostMapping("/etudiant/add")
    public ResponseEntity<EtudiantDTO> save(@RequestBody EtudiantDTO etudiantDTO) {
        logger.log(Level.WARNING, "REST request to add Etudiant");
        return new ResponseEntity<>(etudiantService.save(etudiantDTO), HttpStatus.CREATED);
    }

    @PutMapping("/etudiant/update")
    public ResponseEntity<EtudiantDTO> update(@RequestBody EtudiantDTO etudiantDTO) {
        logger.log(Level.WARNING, "REST request to update Etudiant");
        return ResponseEntity.ok(etudiantService.update(etudiantDTO));
    }

    @DeleteMapping("/etudiant/{id}/delete")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        logger.log(Level.WARNING, "REST request to delete Etudiant");
        etudiantService.delete(id);
        return new ResponseEntity<>("Etudiant deleted succesfully...", HttpStatus.NO_CONTENT);
    }
}
