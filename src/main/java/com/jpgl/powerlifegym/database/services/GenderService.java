package com.jpgl.powerlifegym.database.services;

import com.jpgl.powerlifegym.database.repositories.GenderRepository;
import com.jpgl.powerlifegym.database.models.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderService {

    @Autowired
    GenderRepository repository;

    public List<Gender> All(){
        return (List<Gender>) repository.findAll();
    }

    public Optional<Gender> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(Gender m) {
        return Add(m);
    }

    public boolean Add(Gender model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(Gender m) {
        try {
            repository.delete(m);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
