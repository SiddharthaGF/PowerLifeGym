package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.models.invoice.InvoiceModel;
import com.jpgl.powerlifegym.database.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository repository;

    public List<InvoiceModel> All(){
        return (List<InvoiceModel>) repository.findAll();
    }

    public Optional<InvoiceModel> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(InvoiceModel model) {
        return Add(model);
    }

    public boolean Add(InvoiceModel model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(InvoiceModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
