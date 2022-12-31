package com.jpgl.powerlifegym.services;

import com.jpgl.powerlifegym.models.CellphoneNumber;
import com.jpgl.powerlifegym.repositories.CellphoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CellphoneNumberService {

    @Autowired
    CellphoneNumberRepository repository;

    public List<CellphoneNumber> All(){
        return (List<CellphoneNumber>) repository.findAll();
    }

    public Optional<CellphoneNumber> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(CellphoneNumber model) {
        return Add(model);
    }

    public boolean Add(CellphoneNumber model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(CellphoneNumber model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
