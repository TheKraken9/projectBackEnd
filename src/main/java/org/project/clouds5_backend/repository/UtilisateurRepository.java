package org.project.clouds5_backend.repository;

import org.project.clouds5_backend.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {
    List<Utilisateur> findByEtatNot(Integer etat);
    Utilisateur findByIdUtilisateurAndEtatNot(String id, Integer etat);
}
