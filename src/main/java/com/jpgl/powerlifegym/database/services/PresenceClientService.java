package com.jpgl.powerlifegym.database.services;

import com.jpgl.powerlifegym.database.repositories.CustomerAssistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PresenceClientService {

    @Autowired
    CustomerAssistanceRepository repository;

    public List<com.jpgl.powerlifegym.database.models.CustomerAssistance> All(){
        return (List<com.jpgl.powerlifegym.database.models.CustomerAssistance>) repository.findAll();
    }

    public Optional<com.jpgl.powerlifegym.database.models.CustomerAssistance> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(com.jpgl.powerlifegym.database.models.CustomerAssistance model) {
        return Add(model);
    }

    public boolean Add(com.jpgl.powerlifegym.database.models.CustomerAssistance model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(com.jpgl.powerlifegym.database.models.CustomerAssistance model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
