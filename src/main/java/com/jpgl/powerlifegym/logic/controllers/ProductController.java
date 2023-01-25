package com.jpgl.powerlifegym.logic.controllers;

import com.jpgl.powerlifegym.database.models.offer.product.ProductModel;
import com.jpgl.powerlifegym.logic.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    public List<ProductModel> index() {
        return service.All();
    }

    @GetMapping("/{id}")
    public Optional<ProductModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/{model}")
    public boolean create(@PathVariable ProductModel model) {
        return service.Add(model);
    }

    @DeleteMapping("/{model}")
    public boolean destroy(@PathVariable ProductModel model) {
        return service.Delete(model);
    }

}
