package com.jpgl.powerlifegym.services;

import com.jpgl.powerlifegym.models.Gender;
import com.jpgl.powerlifegym.models.User;
import com.jpgl.powerlifegym.repositories.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
