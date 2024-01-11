package org.project.clouds5_backend.service;

import org.project.clouds5_backend.model.Annonce;
import org.project.clouds5_backend.repository.AnnonceRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AnnonceService {
    private final AnnonceRepository annonceRepository;

    public AnnonceService(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    public List<Annonce> getAllAnnonces() {
        List<Annonce> annonces = annonceRepository.findByEtatNot(10);
        if(annonces.isEmpty()) {
            return Collections.emptyList();
        }else {
            return annonces;
        }
    }

    public Annonce getAnnonceById(String id) {
        Annonce annonce = annonceRepository.findByIdAnnonceAndEtatNot(id, 10);
        if(annonce == null) {
            return null;
        }else {
            return annonce;
        }
    }

    public Annonce createAnnonce(Annonce annonce) {
        try{
            return annonceRepository.save(annonce);
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Annonce updateAnnonceById(String id, Annonce annonce) {
        Optional<Annonce> optionalAnnonce = Optional.ofNullable(annonceRepository.findByIdAnnonceAndEtatNot(id, 10));
        if(optionalAnnonce.isPresent()){
            Annonce annonceToUpdate = optionalAnnonce.get();
            annonceToUpdate.setDateAnnonce(annonce.getDateAnnonce());
            annonceToUpdate.setPrix(annonce.getPrix());
            annonceToUpdate.setVoiture(annonce.getVoiture());
            annonceToUpdate.setVille(annonce.getVille());
            annonceToUpdate.setDescription(annonce.getDescription());
            annonceToUpdate.setEtat(annonce.getEtat());
            annonceToUpdate.setUtilisateur(annonce.getUtilisateur());
            annonceRepository.save(annonceToUpdate);
            return annonceToUpdate;
        }else{
            throw new RuntimeException("Annonce non trouvee");
        }
    }

    public Annonce deleteAnnonceById(String id) {
        Optional<Annonce> optionalAnnonce = Optional.ofNullable(annonceRepository.findByIdAnnonceAndEtatNot(id, 10));
        if(optionalAnnonce.isPresent()){
            Annonce annonceToDelete = optionalAnnonce.get();
            annonceToDelete.setEtat(10);
            return annonceToDelete;
        }else {
            throw new RuntimeException("Annonce non trouvee");
        }
    }
}
