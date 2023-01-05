package com.jpgl.powerlifegym.database.services;

import com.jpgl.powerlifegym.database.models.Cloth;
import com.jpgl.powerlifegym.database.repositories.ClothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothService {

    @Autowired
    ClothRepository repository;

    public List<Cloth> All(){
        return (List<Cloth>) repository.findAll();
    }

    public Optional<Cloth> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(Cloth model) {
        return Add(model);
    }

    public boolean Add(Cloth model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(Cloth model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
