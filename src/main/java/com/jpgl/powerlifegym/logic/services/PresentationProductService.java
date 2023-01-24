package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.models.PresentationModel;
import com.jpgl.powerlifegym.database.repositories.PresentationProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PresentationProductService {

    @Autowired
    PresentationProductRepository repository;

    public List<PresentationModel> All(){
        return (List<PresentationModel>) repository.findAll();
    }

    public Optional<PresentationModel> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(PresentationModel model) {
        return Add(model);
    }

    public boolean Add(PresentationModel model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(PresentationModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
