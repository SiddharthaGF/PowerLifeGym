package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.models.SubscriptionPayment;
import com.jpgl.powerlifegym.database.models.User;
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

    public List<SubscriptionPayment> All(){
        return (List<SubscriptionPayment>) repository.findAll();
    }

    public Optional<SubscriptionPayment> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(SubscriptionPayment model) {
        return Add(model);
    }

    public boolean Add(SubscriptionPayment model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(SubscriptionPayment model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
