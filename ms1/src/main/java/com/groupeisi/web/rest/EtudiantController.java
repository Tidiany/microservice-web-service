package com.groupeisi.web.rest;

import com.groupeisi.service.EtudiantService;
import com.groupeisi.service.dto.EtudiantDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
