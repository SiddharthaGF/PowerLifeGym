package com.jpgl.powerlifegym.services.people.employee;

import com.jpgl.powerlifegym.models.people.employee.InstructorModel;
import com.jpgl.powerlifegym.repositories.people.employee.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    InstructorRepository repository;

    public List<InstructorModel> All(){
        return (List<InstructorModel>) repository.findAll();
    }

    public Optional<InstructorModel> Find(int id) {
        return repository.findById(id);
    }

    public ResponseEntity<?> Update(InstructorModel model) {
        return Add(model);
    }

    public ResponseEntity<?> Add(InstructorModel model) {
        try {
            return new ResponseEntity<>(repository.save(model), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public boolean Delete(InstructorModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
