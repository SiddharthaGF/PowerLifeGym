package com.jpgl.powerlifegym.services.offer.services;

import com.jpgl.powerlifegym.models.offer.services.SubscriptionModel;
import com.jpgl.powerlifegym.repositories.offer.services.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionRepository repository;

    public List<SubscriptionModel> All(){
        return (List<SubscriptionModel>) repository.findAll();
    }

    public Optional<SubscriptionModel> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(SubscriptionModel model) {
        return Add(model);
    }

    public boolean Add(SubscriptionModel model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(SubscriptionModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
