package com.jpgl.powerlifegym.services.offer.services;

import com.jpgl.powerlifegym.models.offer.services.InscriptionModel;
import com.jpgl.powerlifegym.repositories.offer.services.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscriptionService {

    @Autowired
    InscriptionRepository repository;

    public List<InscriptionModel> All(){
        return (List<InscriptionModel>) repository.findAll();
    }

    public Optional<InscriptionModel> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(InscriptionModel model) {
        return Add(model);
    }

    public boolean Add(InscriptionModel model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(InscriptionModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
