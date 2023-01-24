package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.models.CellphoneNumberModel;
import com.jpgl.powerlifegym.database.repositories.CellphoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CellphoneNumberService {

    @Autowired
    CellphoneNumberRepository repository;

    public List<CellphoneNumberModel> All(){
        return (List<CellphoneNumberModel>) repository.findAll();
    }

    public Optional<CellphoneNumberModel> Find(int id) {
        return repository.findById(id);
    }

    public ResponseEntity<?> Update(CellphoneNumberModel model) {
        return Add(model);
    }

    public ResponseEntity<?> Add(CellphoneNumberModel model) {
        try {
            return new ResponseEntity<>(repository.save(model), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public boolean Delete(CellphoneNumberModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean existsByIdOrNumber(String idOrNumber) {
        int id = 0;
        try {
            id = Integer.parseInt(idOrNumber);
        } catch (Exception ex) {
            //
        }
        return repository.existsByIdOrNumber(id, idOrNumber);
    }

    public Optional<CellphoneNumberModel> findByIdOrNumber(String idOrNumber) {
        int id = 0;
        try {
            id = Integer.parseInt(idOrNumber);
        } catch (Exception ex) {
            //
        }
        return repository.findByIdOrNumber(id, idOrNumber);
    }
}
