package com.groupeisi.service.impl;

import com.groupeisi.domain.Etudiant;
import com.groupeisi.repository.EtudiantRepository;
import com.groupeisi.service.EtudiantService;
import com.groupeisi.service.dto.EtudiantDTO;
import com.groupeisi.web.rest.EtudiantController;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class EtudiantServiceImpl implements EtudiantService {
    private final EtudiantRepository etudiantRepository;
    Logger logger = Logger.getLogger(EtudiantController.class.getName());


    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public List<EtudiantDTO> findAll() {
        return etudiantRepository
            .findAll()
            .stream()
            .map(EtudiantDTO::new)
            .toList();
    }

    @Override
    public EtudiantDTO findById(Long id) {
        return etudiantRepository.findById(id).map(EtudiantDTO::new).orElse(null);
    }

    @Override
    public void delete(Long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public EtudiantDTO update(EtudiantDTO dto) {
        Etudiant etudiant = etudiantRepository.findById(dto.getId()).orElseThrow(() -> new RuntimeException("L'étudiant en question n' existe pas"));
        return Optional.of(etudiantRepository.save(etudiant.nom(dto.getNom()).prenom(dto.getPrenom())))
            .map(EtudiantDTO::new)
            .orElse(null);
    }

    @Override
    public EtudiantDTO save(EtudiantDTO dto) {
        logger.log(Level.INFO, """
            EtudiantDTO =>
                Nom: %s,
                Prenom: %s
            """.formatted(dto.getNom(), dto.getPrenom()));
        return Optional.of(etudiantRepository.save(new Etudiant().nom(dto.getNom()).prenom(dto.getPrenom())))
            .map(EtudiantDTO::new)
            .orElse(null);
    }
}
