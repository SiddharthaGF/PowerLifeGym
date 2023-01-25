package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.models.offer.product.ClothModel;
import com.jpgl.powerlifegym.database.repositories.ClothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothService {

    @Autowired
    ClothRepository repository;

    public List<ClothModel> All(){
        return (List<ClothModel>) repository.findAll();
    }

    public Optional<ClothModel> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(ClothModel model) {
        return Add(model);
    }

    public boolean Add(ClothModel model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(ClothModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
