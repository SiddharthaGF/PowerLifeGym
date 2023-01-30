package com.jpgl.powerlifegym.services.people;

import com.jpgl.powerlifegym.repositories.people.ClientRepository;
import com.jpgl.powerlifegym.models.people.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

    public List<ClientModel> All(){
        return (List<ClientModel>) repository.findAll();
    }

    public Optional<ClientModel> Find(String idOrDni) {
        int id = 0;
        try {
            id = Integer.parseInt(idOrDni);
        } catch (Exception ex) {
            //
        }
        return Optional.ofNullable(repository.findByIdOrDni(id, idOrDni));
    }

    public List<ClientModel> Find(String dni, String name, String lastname, String gender, String cellphoneNumber, String email, Timestamp birthdate ){
        if (dni != null) {
            return repository.findByDniContaining(dni);
        } else if (name != null || lastname != null) {
            return repository.findByNameContainingOrLastnameContaining(name, lastname);
        }
        else if (gender != null) {
            return repository.findByGenderName(gender);
        }
        else if (cellphoneNumber != null) {
            return repository.findByCellphoneNumbersNumber(cellphoneNumber);
        }
        else if (email != null) {
            return repository.findByEmail(email);
        }
        return (List<ClientModel>) repository.findAll();
    }

    public ResponseEntity<?> Update(ClientModel model) {
        return Add(model);
    }

    public ResponseEntity<?> Add(ClientModel model) {
        try {
            return  new ResponseEntity<>(repository.save(model), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public boolean Delete(ClientModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Exists(String idOrDni) {
        int id = 0;
        try {
            id = Integer.parseInt(idOrDni);
        } catch (Exception ex) {
            //;
        }
        return repository.existsByIdOrDni(id, idOrDni);
    }

}
