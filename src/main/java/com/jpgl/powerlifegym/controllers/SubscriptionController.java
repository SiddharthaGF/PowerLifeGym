package com.jpgl.powerlifegym.controllers;

import com.jpgl.powerlifegym.models.Subscription;
import com.jpgl.powerlifegym.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class SubscriptionController {

    @Autowired
    SubscriptionService service;

    @GetMapping("/subscription")
    public List<Subscription> index() {
        return service.All();
    }

    @GetMapping("/subscription/{id}")
    public Optional<Subscription> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/subscription/{model}")
    public boolean create(@PathVariable Subscription model) {
        return service.Add(model);
    }

    @DeleteMapping("/subscription/{model}")
    public boolean destroy(@PathVariable Subscription model) {
        return service.Delete(model);
    }

}
