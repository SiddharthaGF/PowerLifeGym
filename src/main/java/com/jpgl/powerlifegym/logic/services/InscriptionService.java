package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.models.Inscription;
import com.jpgl.powerlifegym.database.repositories.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscriptionService {

    @Autowired
    InscriptionRepository repository;

    public List<Inscription> All(){
        return (List<Inscription>) repository.findAll();
    }

    public Optional<Inscription> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(Inscription model) {
        return Add(model);
    }

    public boolean Add(Inscription model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(Inscription model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
