package com.jpgl.powerlifegym.database.controllers;

import com.jpgl.powerlifegym.database.models.Instructor;
import com.jpgl.powerlifegym.database.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class InstructorController {

    @Autowired
    InstructorService service;

    @GetMapping("/instructors")
    public List<Instructor> index() {
        return service.All();
    }

    @GetMapping("/instructor/{id}")
    public Optional<Instructor> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/instructor/{model}")
    public boolean create(@PathVariable Instructor model) {
        return service.Add(model);
    }

    @DeleteMapping("/instructor/{model}")
    public boolean destroy(@PathVariable Instructor model) {
        return service.Delete(model);
    }

}
