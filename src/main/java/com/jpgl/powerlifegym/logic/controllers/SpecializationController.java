package com.jpgl.powerlifegym.logic.controllers;

import com.jpgl.powerlifegym.logic.services.SpecializationService;
import com.jpgl.powerlifegym.database.models.Specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class SpecializationController {

    @Autowired
    SpecializationService service;

    @GetMapping("/specializations")
    public List<Specialization> index() {
        return service.All();
    }

    @GetMapping("/specialization/{id}")
    public Optional<Specialization> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/specialization/{model}")
    public boolean create(@PathVariable Specialization model) {
        return service.Add(model);
    }

    @DeleteMapping("/specialization/{model}")
    public boolean destroy(@PathVariable Specialization model) {
        return service.Delete(model);
    }

}
