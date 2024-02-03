package com.groupeisi.service.impl;

import com.groupeisi.repository.EtudiantRepository;
import com.groupeisi.service.EtudiantService;
import com.groupeisi.service.dto.EtudiantDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {
    private final EtudiantRepository etudiantRepository;

    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public List<EtudiantDTO> findAll() {
        return etudiantRepository
            .findAll()
            .stream()
            .map(e -> new EtudiantDTO(e.getId(), e.getNom(), e.getPrenom()))
            .toList();
    }
}
