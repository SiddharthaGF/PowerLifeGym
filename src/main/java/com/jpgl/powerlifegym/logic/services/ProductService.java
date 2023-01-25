package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.models.offer.product.ProductModel;
import com.jpgl.powerlifegym.database.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<ProductModel> All(){
        return (List<ProductModel>) repository.findAll();
    }

    public Optional<ProductModel> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(ProductModel model) {
        return Add(model);
    }

    public boolean Add(ProductModel model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(ProductModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
