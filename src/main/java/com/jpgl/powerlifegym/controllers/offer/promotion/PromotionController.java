package com.jpgl.powerlifegym.controllers.offer.promotion;

import com.jpgl.powerlifegym.models.offer.promotion.PromotionModel;
import com.jpgl.powerlifegym.services.offer.promotion.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class PromotionController {

    @Autowired
    PromotionService service;

    @GetMapping("/promotions")
    public List<PromotionModel> index() {
        return service.All();
    }

    @GetMapping("/promotion/{id}")
    public Optional<PromotionModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/promotion/{model}")
    public boolean create(@PathVariable PromotionModel model) {
        return service.Add(model);
    }

    @DeleteMapping("/promotion/{model}")
    public boolean destroy(@PathVariable PromotionModel model) {
        return service.Delete(model);
    }

}
