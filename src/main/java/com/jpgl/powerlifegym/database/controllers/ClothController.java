package com.jpgl.powerlifegym.database.controllers;

import com.jpgl.powerlifegym.database.models.Cloth;
import com.jpgl.powerlifegym.database.services.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class ClothController {

    @Autowired
    ClothService service;

    @GetMapping("/cloth")
    public List<Cloth> index() {
        return service.All();
    }

    @GetMapping("/cloth/{id}")
    public Optional<Cloth> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/cloth/{model}")
    public boolean create(@PathVariable Cloth model) {
        return service.Add(model);
    }

    @DeleteMapping("/cloth/{model}")
    public boolean destroy(@PathVariable Cloth model) {
        return service.Delete(model);
    }

}
