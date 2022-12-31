package com.jpgl.powerlifegym.controllers;

import com.jpgl.powerlifegym.models.Supplement;
import com.jpgl.powerlifegym.services.SupplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class SupplementController {

    @Autowired
    SupplementService service;

    @GetMapping("/supplement")
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
