package com.jpgl.powerlifegym.database.services;

import com.jpgl.powerlifegym.database.models.Supplement;
import com.jpgl.powerlifegym.database.repositories.SupplementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplementService {

    @Autowired
    SupplementRepository repository;

    public List<Supplement> All(){
        return (List<Supplement>) repository.findAll();
    }

    public Optional<Supplement> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(Supplement model) {
        return Add(model);
    }

    public boolean Add(Supplement model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(Supplement model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
