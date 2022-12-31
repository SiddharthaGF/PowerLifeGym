package com.jpgl.powerlifegym.services;

import com.jpgl.powerlifegym.models.Person;
import com.jpgl.powerlifegym.repositories.PersonRepository;
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

    public Optional<Person> Find(int id) {
        return repository.findById(id);
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

}
