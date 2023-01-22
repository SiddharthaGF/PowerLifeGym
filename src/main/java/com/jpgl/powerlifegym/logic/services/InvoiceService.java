package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.models.Invoice;
import com.jpgl.powerlifegym.database.models.Supplement;
import com.jpgl.powerlifegym.database.repositories.InvoiceRepository;
import com.jpgl.powerlifegym.database.repositories.SupplementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository repository;

    public List<Invoice> All(){
        return (List<Invoice>) repository.findAll();
    }

    public Optional<Invoice> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(Invoice model) {
        return Add(model);
    }

    public boolean Add(Invoice model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(Invoice model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
