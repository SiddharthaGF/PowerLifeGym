package com.jpgl.powerlifegym.logic.controllers;

import com.jpgl.powerlifegym.database.models.SubscriptionPayment;
import com.jpgl.powerlifegym.logic.services.SubscriptionPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class SubscriptionPaymentController {

    @Autowired
    SubscriptionPaymentService service;

    @GetMapping("/subscription_payments")
    public List<SubscriptionPayment> index() {
        return service.All();
    }

    @GetMapping("/subscription_payment/{id}")
    public Optional<SubscriptionPayment> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/subscription_payment/{model}")
    public boolean create(@PathVariable SubscriptionPayment model) {
        return service.Add(model);
    }

    @DeleteMapping("/subscription_payment/{model}")
    public boolean destroy(@PathVariable SubscriptionPayment model) {
        return service.Delete(model);
    }

}
