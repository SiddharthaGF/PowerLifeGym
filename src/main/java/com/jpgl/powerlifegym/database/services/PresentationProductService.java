package com.jpgl.powerlifegym.database.services;

import com.jpgl.powerlifegym.database.models.PresentationProduct;
import com.jpgl.powerlifegym.database.repositories.PresentationProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PresentationProductService {

    @Autowired
    PresentationProductRepository repository;

    public List<PresentationProduct> All(){
        return (List<PresentationProduct>) repository.findAll();
    }

    public Optional<PresentationProduct> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(PresentationProduct model) {
        return Add(model);
    }

    public boolean Add(PresentationProduct model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(PresentationProduct model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
