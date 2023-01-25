package com.jpgl.powerlifegym.logic.controllers;

import com.jpgl.powerlifegym.database.models.offer.services.SubscriptionModel;
import com.jpgl.powerlifegym.logic.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class SubscriptionController {

    @Autowired
    SubscriptionService service;

    @GetMapping("/subscriptions")
    public List<SubscriptionModel> index() {
        return service.All();
    }

    @GetMapping("/subscription/{id}")
    public Optional<SubscriptionModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/subscription/{model}")
    public boolean create(@PathVariable SubscriptionModel model) {
        return service.Add(model);
    }

    @DeleteMapping("/subscription/{model}")
    public boolean destroy(@PathVariable SubscriptionModel model) {
        return service.Delete(model);
    }

}
