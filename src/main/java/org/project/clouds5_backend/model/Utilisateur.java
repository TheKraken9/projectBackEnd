package org.project.clouds5_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Utilisateur {
    @Id
    @Column(name = "id_utilisateur")
    private String idUtilisateur;
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;
    @NotBlank(message = "Le prenom est obligatoire")
    private String prenom;
    @ManyToOne
    @JoinColumn(name = "id_ville", nullable = false)
    @NotNull(message = "La ville est obligatoire")
    private Ville ville;
    @NotBlank(message = "L'adresse est obligatoire")
    private String adresse;
    @NotBlank(message = "Le contact est obligatoire")
    private String contact;
    @NotBlank(message = "L'email est obligatoire")
    private String mail;
    @NotBlank(message = "Le mot de passe est obligatoire")
    @Column(name = "mot_de_passe", nullable = false)
    private String motDePasse;
    private int role;
    private int etat;

    public String getFullId() {
        return "USR" + this.idUtilisateur;
    }

    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
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

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Utilisateur() {
    }

    public Utilisateur(String idUtilisateur, String nom, String prenom, Ville ville, String adresse, String contact, String mail, String motDePasse, int role) {
        this.setIdUtilisateur(idUtilisateur);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setVille(ville);
        this.setAdresse(adresse);
        this.setContact(contact);
        this.setMail(mail);
        this.setMotDePasse(motDePasse);
        this.setRole(role);
    }
}
