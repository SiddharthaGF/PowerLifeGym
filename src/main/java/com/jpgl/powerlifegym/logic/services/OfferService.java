package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.models.offer.OfferModel;
import com.jpgl.powerlifegym.database.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {

    @Autowired
    OfferRepository repository;

    public List<OfferModel> All(){
        return (List<OfferModel>) repository.findAll();
    }

    public Optional<OfferModel> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(OfferModel model) {
        return Add(model);
    }

    public boolean Add(OfferModel model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(OfferModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
