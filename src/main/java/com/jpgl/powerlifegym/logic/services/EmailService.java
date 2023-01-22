package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.models.Email;
import com.jpgl.powerlifegym.database.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService {

    @Autowired
    EmailRepository repository;

    public List<Email> All(){
        return (List<Email>) repository.findAll();
    }

    public Optional<Email> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(Email model) {
        return Add(model);
    }

    public boolean Add(Email model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(Email model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
