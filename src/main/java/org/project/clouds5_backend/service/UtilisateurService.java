package org.project.clouds5_backend.service;

import org.project.clouds5_backend.model.Utilisateur;
import org.project.clouds5_backend.model.Ville;
import org.project.clouds5_backend.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur> getAllUtilisateurs() {
        List<Utilisateur> utilisateur = utilisateurRepository.findByEtatNot(10);
        if(utilisateur.isEmpty()) {
            return Collections.emptyList();
        }else {
            return utilisateur;
        }
    }

    public Utilisateur getUtilisateurById(String id) {
        Utilisateur utilisateur = utilisateurRepository.findByIdUtilisateurAndEtatNot(id, 10);
        if(utilisateur == null) {
            return null;
        }
        return utilisateur;
    }

    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        try{
            utilisateur.setIdUtilisateur(utilisateur.getFullId());
            return utilisateurRepository.save(utilisateur);
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Utilisateur updateUtilisateurById(String id, Utilisateur utilisateur) {
        Optional<Utilisateur> optionalUtilisateur = Optional.ofNullable(utilisateurRepository.findByIdUtilisateurAndEtatNot(id, 10));
        if(optionalUtilisateur.isPresent()){
            Utilisateur utilisateurToUpdate = optionalUtilisateur.get();
            utilisateurToUpdate.setNom(utilisateur.getNom());
            utilisateurToUpdate.setPrenom(utilisateur.getPrenom());
            utilisateurToUpdate.setVille(utilisateur.getVille());
            utilisateurToUpdate.setAdresse(utilisateur.getAdresse());
            utilisateurToUpdate.setContact(utilisateur.getContact());
            utilisateurToUpdate.setMail(utilisateur.getMail());
            utilisateurToUpdate.setMotDePasse(utilisateur.getMotDePasse());
            utilisateurToUpdate.setRole(utilisateur.getRole());
            utilisateurRepository.save(utilisateurToUpdate);
            return utilisateurToUpdate;
        }else {
            throw new RuntimeException("Utilisateur non trouvee");
        }
    }

    public Utilisateur deleteUtilisateurById(String id) {
        Optional<Utilisateur> optionalUtilisateur = Optional.ofNullable(utilisateurRepository.findByIdUtilisateurAndEtatNot(id, 10));
        if(optionalUtilisateur.isPresent()){
            Utilisateur utilisateurToDelete = optionalUtilisateur.get();
            utilisateurToDelete.setEtat(10);
            utilisateurRepository.save(utilisateurToDelete);
            return utilisateurToDelete;
        }else {
            throw new RuntimeException("Utilisateur non trouvee");
        }
    }
}
