package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.repositories.PromotionRepository;
import com.jpgl.powerlifegym.database.models.promotion.PromotionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionService {

    @Autowired
    PromotionRepository repository;

    public List<PromotionModel> All(){
        return (List<PromotionModel>) repository.findAll();
    }

    public Optional<PromotionModel> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(PromotionModel model) {
        return Add(model);
    }

    public boolean Add(PromotionModel model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(PromotionModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
