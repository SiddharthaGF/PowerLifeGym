package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.repositories.PromotionRepository;
import com.jpgl.powerlifegym.database.models.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionService {

    @Autowired
    PromotionRepository repository;

    public List<Promotion> All(){
        return (List<Promotion>) repository.findAll();
    }

    public Optional<Promotion> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(Promotion model) {
        return Add(model);
    }

    public boolean Add(Promotion model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(Promotion model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
