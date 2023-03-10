package com.jpgl.powerlifegym.controllers.invoice;

import com.jpgl.powerlifegym.models.invoice.SubscriptionPaymentModel;
import com.jpgl.powerlifegym.services.invoice.SubscriptionPaymentService;
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
    public List<SubscriptionPaymentModel> index() {
        return service.All();
    }

    @GetMapping("/subscription_payment/{id}")
    public Optional<SubscriptionPaymentModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/subscription_payment/{model}")
    public boolean create(@PathVariable SubscriptionPaymentModel model) {
        return service.Add(model);
    }

    @DeleteMapping("/subscription_payment/{model}")
    public boolean destroy(@PathVariable SubscriptionPaymentModel model) {
        return service.Delete(model);
    }

}
