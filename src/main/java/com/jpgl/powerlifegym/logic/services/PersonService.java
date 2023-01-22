package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.repositories.PersonRepository;
import com.jpgl.powerlifegym.database.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public List<Person> All(){
        return (List<Person>) repository.findAll();
    }

    public Optional<Person> Find(String idOrDni) {
        int id = 0;
        String dni = null;
        try {
            id = Integer.parseInt(idOrDni);
        } catch (Exception ex) {
            dni = idOrDni;
        }
        return repository.findByIdOrDni(id, dni);
    }

    public boolean Update(Person model) {
        return Add(model);
    }

    public boolean Add(Person model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(Person model) {
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
