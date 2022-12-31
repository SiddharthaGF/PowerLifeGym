package com.jpgl.powerlifegym.services;

import com.jpgl.powerlifegym.models.Product;
import com.jpgl.powerlifegym.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> All(){
        return (List<Product>) repository.findAll();
    }

    public Optional<Product> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(Product model) {
        return Add(model);
    }

    public boolean Add(Product model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(Product model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
