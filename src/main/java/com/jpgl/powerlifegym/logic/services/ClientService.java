package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.repositories.ClientRepository;
import com.jpgl.powerlifegym.database.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

    public List<Client> All(){
        return (List<Client>) repository.findAll();
    }

    public Optional<Client> Find(String idOrDni) {
        int id = 0;
        try {
            id = Integer.parseInt(idOrDni);
        } catch (Exception ex) {
            //
        }
        return Optional.ofNullable(repository.findByIdOrDni(id, idOrDni));
    }

    public List<Client> Find(String dni, String name, String lastname, String gender, String cellphoneNumber, String email, Timestamp birthdate ){
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
        return (List<Client>) repository.findAll();
    }

    public boolean Update(Client model) {
        return Add(model);
    }

    public boolean Add(Client model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(Client model) {
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
