package com.jpgl.powerlifegym.controllers.offer.promotion;

import com.jpgl.powerlifegym.models.offer.promotion.ProductPromotionModel;
import com.jpgl.powerlifegym.services.offer.promotion.ProductPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/product-promotion")
public class ProductPromotionController {

    @Autowired
    ProductPromotionService service;

    @GetMapping
    public List<ProductPromotionModel> index() {
        return service.All();
    }

    @GetMapping("/{id}")
    public Optional<ProductPromotionModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/{model}")
    public boolean create(@PathVariable ProductPromotionModel model) {
        return service.Add(model);
    }

    @DeleteMapping("/{model}")
    public boolean destroy(@PathVariable ProductPromotionModel model) {
        return service.Delete(model);
    }

}
