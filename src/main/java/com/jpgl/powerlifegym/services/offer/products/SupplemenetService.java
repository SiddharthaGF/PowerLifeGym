package com.jpgl.powerlifegym.services.offer.products;

import com.jpgl.powerlifegym.models.offer.product.SupplementModel;
import com.jpgl.powerlifegym.repositories.offer.products.SupplementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplemenetService {

    @Autowired
    SupplementRepository repository;

    public List<SupplementModel> All(){
        return (List<SupplementModel>) repository.findAll();
    }

    public Optional<SupplementModel> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(SupplementModel model) {
        return Add(model);
    }

    public boolean Add(SupplementModel model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(SupplementModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
