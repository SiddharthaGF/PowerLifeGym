package com.jpgl.powerlifegym.database.controllers;

import com.jpgl.powerlifegym.database.services.SupplementService;
import com.jpgl.powerlifegym.database.models.Supplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class SupplementController {

    @Autowired
    SupplementService service;

    @GetMapping("/supplements")
    public List<Supplement> index() {
        return service.All();
    }

    @GetMapping("/supplement/{id}")
    public Optional<Supplement> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/supplement/{model}")
    public boolean create(@PathVariable Supplement model) {
        return service.Add(model);
    }

    @DeleteMapping("/supplement/{model}")
    public boolean destroy(@PathVariable Supplement model) {
        return service.Delete(model);
    }

}
