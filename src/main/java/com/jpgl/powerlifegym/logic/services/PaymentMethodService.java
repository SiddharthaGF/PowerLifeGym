package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.models.PaymentMethodModel;
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

    public List<PaymentMethodModel> All(){
        return (List<PaymentMethodModel>) repository.findAll();
    }

    public Optional<PaymentMethodModel> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(PaymentMethodModel model) {
        return Add(model);
    }

    public boolean Add(PaymentMethodModel model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(PaymentMethodModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
