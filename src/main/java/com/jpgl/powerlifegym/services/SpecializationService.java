package com.jpgl.powerlifegym.services;

import com.jpgl.powerlifegym.models.Specialization;
import com.jpgl.powerlifegym.repositories.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecializationService {

    @Autowired
    SpecializationRepository repository;

    public List<Specialization> All(){
        return (List<Specialization>) repository.findAll();
    }

    public Optional<Specialization> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(Specialization model) {
        return Add(model);
    }

    public boolean Add(Specialization model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(Specialization model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
