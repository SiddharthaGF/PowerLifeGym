package com.jpgl.powerlifegym.controllers;

import com.jpgl.powerlifegym.models.Promotion;
import com.jpgl.powerlifegym.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class PromotionController {

    @Autowired
    PromotionService service;

    @GetMapping("/promotion")
    public List<Promotion> index() {
        return service.All();
    }

    @GetMapping("/promotion/{id}")
    public Optional<Promotion> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/promotion/{model}")
    public boolean create(@PathVariable Promotion model) {
        return service.Add(model);
    }

    @DeleteMapping("/promotion/{model}")
    public boolean destroy(@PathVariable Promotion model) {
        return service.Delete(model);
    }

}
