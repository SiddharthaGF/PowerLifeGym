package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.models.Instructor;
import com.jpgl.powerlifegym.database.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    InstructorRepository repository;

    public List<Instructor> All(){
        return (List<Instructor>) repository.findAll();
    }

    public Optional<Instructor> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(Instructor model) {
        return Add(model);
    }

    public boolean Add(Instructor model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(Instructor model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
