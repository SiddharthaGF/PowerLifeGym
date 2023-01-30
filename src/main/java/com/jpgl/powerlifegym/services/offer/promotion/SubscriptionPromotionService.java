package com.jpgl.powerlifegym.services.offer.promotion;

import com.jpgl.powerlifegym.controllers.offer.promotion.SubscriptionPromotionController;
import com.jpgl.powerlifegym.repositories.offer.promotion.SubscriptionPromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionPromotionService {

    @Autowired
    SubscriptionPromotionRepository repository;

    public List<SubscriptionPromotionController> All(){
        return (List<SubscriptionPromotionController>) repository.findAll();
    }

    public Optional<SubscriptionPromotionController> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(SubscriptionPromotionController model) {
        return Add(model);
    }

    public boolean Add(SubscriptionPromotionController model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(SubscriptionPromotionController model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
