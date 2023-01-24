package com.jpgl.powerlifegym.logic.controllers;

import com.jpgl.powerlifegym.logic.services.SpecializationService;
import com.jpgl.powerlifegym.database.models.SpecializationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class SpecializationController {

    @Autowired
    SpecializationService service;

    @GetMapping("/specializations")
    public List<SpecializationModel> index() {
        return service.All();
    }

    @GetMapping("/specialization/{id}")
    public Optional<SpecializationModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/specialization/{model}")
    public ResponseEntity<?> update(@PathVariable SpecializationModel model) {
        return service.Add(model);
    }

    @PostMapping ("/specialization")
    public ResponseEntity<?> create(@RequestBody SpecializationModel model) {
        return service.Add(model);
    }

    @DeleteMapping("/specialization/{model}")
    public boolean destroy(@PathVariable SpecializationModel model) {
        return service.Delete(model);
    }

}
