package com.jpgl.powerlifegym.database.services;

import com.jpgl.powerlifegym.database.models.PresenceClient;
import com.jpgl.powerlifegym.database.repositories.CustomerAssistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PresenceClientService {

    @Autowired
    CustomerAssistanceRepository repository;

    public List<PresenceClient> All(){
        return (List<PresenceClient>) repository.findAll();
    }

    public Optional<PresenceClient> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(PresenceClient model) {
        return Add(model);
    }

    public boolean Add(PresenceClient model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(PresenceClient model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
