package com.jpgl.powerlifegym.services;

import com.jpgl.powerlifegym.models.Subscription;
import com.jpgl.powerlifegym.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionRepository repository;

    public List<Subscription> All(){
        return (List<Subscription>) repository.findAll();
    }

    public Optional<Subscription> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(Subscription model) {
        return Add(model);
    }

    public boolean Add(Subscription model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(Subscription model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}