package com.groupeisi.service.dto;

import com.groupeisi.domain.Etudiant;

public class EtudiantDTO {
    private Long id;
    private String nom;
    private String prenom;

    public EtudiantDTO() {
    }

    public EtudiantDTO(Long id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public EtudiantDTO(Etudiant etudiant) {
        this.id = etudiant.getId();
        this.nom = etudiant.getNom();
        this.prenom = etudiant.getPrenom();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
