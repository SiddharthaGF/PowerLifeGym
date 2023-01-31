package com.jpgl.powerlifegym.services.offer.promotion;

import com.jpgl.powerlifegym.models.offer.promotion.SubscriptionPromotionModel;
import com.jpgl.powerlifegym.repositories.offer.promotion.SubscriptionPromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionPromotionService {

    @Autowired
    SubscriptionPromotionRepository repository;

    public List<SubscriptionPromotionModel> All(){
        return (List<SubscriptionPromotionModel>) repository.findAll();
    }

    public Optional<SubscriptionPromotionModel> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(SubscriptionPromotionModel model) {
        return Add(model);
    }

    public boolean Add(SubscriptionPromotionModel model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(SubscriptionPromotionModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
