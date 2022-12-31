package com.jpgl.powerlifegym.controllers;

import com.jpgl.powerlifegym.models.Product;
import com.jpgl.powerlifegym.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/product")
    public List<Product> index() {
        return service.All();
    }

    @GetMapping("/product/{id}")
    public Optional<Product> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/product/{model}")
    public boolean create(@PathVariable Product model) {
        return service.Add(model);
    }

    @DeleteMapping("/product/{model}")
    public boolean destroy(@PathVariable Product model) {
        return service.Delete(model);
    }

}
