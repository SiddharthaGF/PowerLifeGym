package com.jpgl.powerlifegym.controllers.people.employee;

import com.jpgl.powerlifegym.services.people.employee.SpecializationService;
import com.jpgl.powerlifegym.models.people.employee.SpecializationModel;
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
