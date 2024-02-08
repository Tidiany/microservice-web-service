package com.groupeisi.domain;

import com.groupeisi.service.dto.EtudiantDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;

    public Etudiant() {
    }

    public Etudiant(Long id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Etudiant(EtudiantDTO etudiantDTO) {
        this.id = etudiantDTO.getId();
        this.nom = etudiantDTO.getNom();
        this.prenom = etudiantDTO.getPrenom();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Etudiant id(Long id) {
        this.id = id;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Etudiant nom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Etudiant prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }
}
