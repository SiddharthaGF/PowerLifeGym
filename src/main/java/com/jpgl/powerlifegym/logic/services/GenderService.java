package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.models.ClientModel;
import com.jpgl.powerlifegym.database.repositories.GenderRepository;
import com.jpgl.powerlifegym.database.models.GenderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderService {

    @Autowired
    GenderRepository repository;

    public GenderModel Formatter(GenderModel gender) {
        gender.setName(gender.getName().trim().toUpperCase());
        gender.setDescription(gender.getDescription().trim().toUpperCase());
        if (gender.getDescription().isEmpty()) {
            gender.setDescription(null);
        }
        return gender;
    }

    public void Validate(GenderModel gender) throws Exception {
        if (gender.getName().isEmpty() || gender.getName()==null)
            throw new Exception("El campo nombre.genero no puede ser nulo/vacío");
    }

    public List<GenderModel> All(){
        return (List<GenderModel>) repository.findAll();
    }

    public Optional<GenderModel> Find(int id) {
        return repository.findById(id);
    }

    public ResponseEntity<?> Update(GenderModel m) {
        return Add(m);
    }

    public ResponseEntity<?> Add(GenderModel model) {
        try {
            model = Formatter(model);
            Validate(model);
            return new ResponseEntity<>(repository.save(model), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public boolean Delete(GenderModel m) {
        try {
            repository.delete(m);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean existsByIdOrName(String idOrName) {
        int id = 0;
        try {
            id = Integer.parseInt(idOrName);
        } catch (Exception ex) {
            //
        }
        return repository.existsByIdOrName(id, idOrName);
    }
}
