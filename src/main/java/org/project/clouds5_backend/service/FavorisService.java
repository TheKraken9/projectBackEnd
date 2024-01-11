package org.project.clouds5_backend.service;

import org.project.clouds5_backend.model.Favoris;
import org.project.clouds5_backend.repository.FavorisRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class FavorisService {
    private final FavorisRepository favorisRepository;

    public FavorisService(FavorisRepository favorisRepository) {
        this.favorisRepository = favorisRepository;
    }

    public List<Favoris> getAllFavoris() {
        List<Favoris> favoris = favorisRepository.findAll();
        if(favoris.isEmpty()){
            return Collections.emptyList();
        }else{
            return favoris;
        }
    }

    public Favoris getFavorisById(String id) {
        Favoris favoris = favorisRepository.findById(id).orElse(null);
        if(favoris == null) {
            return null;
        }
        return favoris;
    }

    public Favoris createFavoris(Favoris favoris) {
        try{
            return favorisRepository.save(favoris);
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Favoris updateFavorisById(String id, Favoris favoris) {
        Favoris favorisToUpdate = favorisRepository.findById(id).orElse(null);
        if (favorisToUpdate != null) {
            favorisToUpdate.setUtilisateur(favoris.getUtilisateur());
            favorisToUpdate.setAnnonce(favoris.getAnnonce());
            favorisRepository.save(favorisToUpdate);
            return favorisToUpdate;
        } else {
            throw new RuntimeException("Favoris non trouvee");
        }
    }

    public Favoris deleteFavorisById(String id) {
        Favoris favorisToDelete = favorisRepository.findById(id).orElse(null);
        if(favorisToDelete != null){
            favorisRepository.delete(favorisToDelete);
            return favorisToDelete;
        }else{
            throw new RuntimeException("Favoris non trouvee");
        }
    }
}
