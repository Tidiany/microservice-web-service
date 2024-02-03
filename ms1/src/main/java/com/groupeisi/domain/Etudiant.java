package com.groupeisi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Etudiant {

    @Id
    private Long id;
    private String nom;
    private String prenom;

    public void setId(Long id) {
        this.id = id;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
