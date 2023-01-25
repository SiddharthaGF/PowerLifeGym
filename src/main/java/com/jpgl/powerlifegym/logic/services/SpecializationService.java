package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.models.person.employee.SpecializationModel;
import com.jpgl.powerlifegym.database.repositories.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SpecializationService {

    @Autowired
    SpecializationRepository repository;

    public List<SpecializationModel> All(){
        return (List<SpecializationModel>) repository.findAll();
    }

    public Optional<SpecializationModel> Find(int id) {
        return repository.findById(id);
    }

    public ResponseEntity<?> Update(SpecializationModel model) {
        return Add(model);
    }

    @Transactional
    public ResponseEntity<?> Add(SpecializationModel model) {
        try {
            return new ResponseEntity<>(repository.save(model), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public boolean Delete(SpecializationModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
