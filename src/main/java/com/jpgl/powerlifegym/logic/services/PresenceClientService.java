package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.models.offer.services.PresenceClientsModel;
import com.jpgl.powerlifegym.database.repositories.CustomerAssistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PresenceClientService {

    @Autowired
    CustomerAssistanceRepository repository;

    public List<PresenceClientsModel> All(){
        return (List<PresenceClientsModel>) repository.findAll();
    }

    public Optional<PresenceClientsModel> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(PresenceClientsModel model) {
        return Add(model);
    }

    public boolean Add(PresenceClientsModel model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(PresenceClientsModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
