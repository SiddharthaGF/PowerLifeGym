package com.jpgl.powerlifegym.services.invoice;

import com.jpgl.powerlifegym.models.invoice.SubscriptionPaymentModel;
import com.jpgl.powerlifegym.repositories.invoice.SubscriptionPaymentRepository;
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
