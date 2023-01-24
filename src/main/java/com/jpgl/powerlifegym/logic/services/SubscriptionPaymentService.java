package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.models.SubscriptionPaymentModel;
import com.jpgl.powerlifegym.database.repositories.SubscriptionPaymentRepository;
import com.jpgl.powerlifegym.database.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionPaymentService {

    @Autowired
    SubscriptionPaymentRepository repository;

    public List<SubscriptionPaymentModel> All(){
        return (List<SubscriptionPaymentModel>) repository.findAll();
    }

    public Optional<SubscriptionPaymentModel> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(SubscriptionPaymentModel model) {
        return Add(model);
    }

    public boolean Add(SubscriptionPaymentModel model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(SubscriptionPaymentModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
