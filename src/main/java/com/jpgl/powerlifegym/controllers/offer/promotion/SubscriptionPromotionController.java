package com.jpgl.powerlifegym.controllers.offer.promotion;

import com.jpgl.powerlifegym.models.offer.promotion.SubscriptionPromotionModel;
import com.jpgl.powerlifegym.services.offer.promotion.SubscriptionPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/subscription-promotion")
public class SubscriptionPromotionController {

    @Autowired
    SubscriptionPromotionService service;

    @GetMapping
    public List<SubscriptionPromotionModel> index() {
        return service.All();
    }

    @GetMapping("/{id}")
    public Optional<SubscriptionPromotionModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/{model}")
    public boolean create(@PathVariable SubscriptionPromotionModel model) {
        return service.Add(model);
    }

    @DeleteMapping("/{model}")
    public boolean destroy(@PathVariable SubscriptionPromotionModel model) {
        return service.Delete(model);
    }

}
