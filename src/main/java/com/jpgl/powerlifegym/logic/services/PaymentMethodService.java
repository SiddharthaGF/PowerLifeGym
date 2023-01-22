package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.models.CellphoneNumber;
import com.jpgl.powerlifegym.database.models.PaymentMethod;
import com.jpgl.powerlifegym.database.repositories.CellphoneNumberRepository;
import com.jpgl.powerlifegym.database.repositories.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {

    @Autowired
    PaymentMethodRepository repository;

    public List<PaymentMethod> All(){
        return (List<PaymentMethod>) repository.findAll();
    }

    public Optional<PaymentMethod> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(PaymentMethod model) {
        return Add(model);
    }

    public boolean Add(PaymentMethod model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(PaymentMethod model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
