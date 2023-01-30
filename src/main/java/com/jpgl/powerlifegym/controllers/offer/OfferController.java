package com.jpgl.powerlifegym.controllers.offer;

import com.jpgl.powerlifegym.models.offer.OfferModel;
import com.jpgl.powerlifegym.services.offer.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/offer")
public class OfferController {

    @Autowired
    OfferService service;

    @GetMapping
    public List<OfferModel> index() {
        return service.All();
    }

    @GetMapping("/{id}")
    public Optional<OfferModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/{model}")
    public boolean create(@PathVariable OfferModel model) {
        return service.Add(model);
    }

    @DeleteMapping("/{model}")
    public boolean destroy(@PathVariable OfferModel model) {
        return service.Delete(model);
    }

}
