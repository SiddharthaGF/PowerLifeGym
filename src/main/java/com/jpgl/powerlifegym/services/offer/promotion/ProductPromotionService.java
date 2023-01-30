package com.jpgl.powerlifegym.services.offer.promotion;

import com.jpgl.powerlifegym.models.offer.promotion.ProductPromotionModel;
import com.jpgl.powerlifegym.repositories.offer.promotion.ProductPromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductPromotionService {

    @Autowired
    ProductPromotionRepository repository;

    public List<ProductPromotionModel> All(){
        return (List<ProductPromotionModel>) repository.findAll();
    }

    public Optional<ProductPromotionModel> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(ProductPromotionModel model) {
        return Add(model);
    }

    public boolean Add(ProductPromotionModel model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(ProductPromotionModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
