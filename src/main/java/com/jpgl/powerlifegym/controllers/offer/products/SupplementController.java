package com.jpgl.powerlifegym.controllers.offer.products;

import com.jpgl.powerlifegym.models.offer.product.SupplementModel;
import com.jpgl.powerlifegym.services.offer.products.SupplemenetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/supplement")
public class SupplementController {

    @Autowired
    SupplemenetService service;

    @GetMapping
    public List<SupplementModel> index() {
        return service.All();
    }

    @GetMapping("/{id}")
    public Optional<SupplementModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/{model}")
    public boolean update(@PathVariable SupplementModel model) {
        return service.Add(model);
    }

    @PostMapping
    public boolean create(@RequestBody SupplementModel model) {
        return service.Add(model);
    }

    @DeleteMapping("/{model}")
    public boolean destroy(@PathVariable SupplementModel model) {
        return service.Delete(model);
    }

}
