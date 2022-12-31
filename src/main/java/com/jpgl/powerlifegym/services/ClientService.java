package com.jpgl.powerlifegym.services;

import com.jpgl.powerlifegym.models.Client;
import com.jpgl.powerlifegym.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

    public List<Client> All(){
        return (List<Client>) repository.findAll();
    }

    public Optional<Client> Find(int id) {
        return repository.findById(id);
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

}
