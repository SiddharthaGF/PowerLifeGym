package com.jpgl.powerlifegym.logic.controllers;

import com.jpgl.powerlifegym.logic.services.SpecializationService;
import com.jpgl.powerlifegym.database.models.person.employee.SpecializationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/specialization")
public class SpecializationController {

    @Autowired
    SpecializationService service;

    @GetMapping
    public List<SpecializationModel> index() {
        return service.All();
    }

    @GetMapping("/{id}")
    public Optional<SpecializationModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/{model}")
    public ResponseEntity<?> update(@PathVariable SpecializationModel model) {
        return service.Add(model);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody SpecializationModel model) {
        return service.Add(model);
    }

    @DeleteMapping("/{model}")
    public boolean destroy(@PathVariable SpecializationModel model) {
        return service.Delete(model);
    }

}
