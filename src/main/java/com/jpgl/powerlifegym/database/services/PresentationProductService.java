package com.jpgl.powerlifegym.database.services;

import com.jpgl.powerlifegym.database.models.Presentation;
import com.jpgl.powerlifegym.database.repositories.PresentationProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PresentationProductService {

    @Autowired
    PresentationProductRepository repository;

    public List<Presentation> All(){
        return (List<Presentation>) repository.findAll();
    }

    public Optional<Presentation> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(Presentation model) {
        return Add(model);
    }

    public boolean Add(Presentation model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(Presentation model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
