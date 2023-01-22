package com.jpgl.powerlifegym.logic.controllers;

import com.jpgl.powerlifegym.database.models.PaymentMethod;
import com.jpgl.powerlifegym.logic.services.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class PaymentMethodController {

    @Autowired
    PaymentMethodService service;

    @GetMapping("/payment_methods")
    public List<PaymentMethod> index() {
        return service.All();
    }

    @GetMapping("/payment_method/{id}")
    public Optional<PaymentMethod> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/payment_methods/{model}")
    public boolean create(@PathVariable PaymentMethod model) {
        return service.Add(model);
    }

    @DeleteMapping("/payment_methods/{model}")
    public boolean destroy(@PathVariable PaymentMethod model) {
        return service.Delete(model);
    }

}
