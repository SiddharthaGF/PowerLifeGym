package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.models.EmailModel;
import com.jpgl.powerlifegym.database.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService {

    @Autowired
    EmailRepository repository;

    public List<EmailModel> All(){
        return (List<EmailModel>) repository.findAll();
    }

    public Optional<EmailModel> Find(int id) {
        return repository.findById(id);
    }

    public ResponseEntity<?> Update(EmailModel model) {
        return Add(model);
    }

    public ResponseEntity<?> Add(EmailModel model) {
        try {
            return new ResponseEntity<>(repository.save(model), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public boolean Delete(EmailModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
