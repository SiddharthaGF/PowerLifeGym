package com.jpgl.powerlifegym.controllers;

import com.jpgl.powerlifegym.models.Person;
import com.jpgl.powerlifegym.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class PersonController {

    @Autowired
    PersonService service;

    @GetMapping("/person")
    public List<Person> index() {
        return service.All();
    }

    @GetMapping("/person/{id}")
    public Optional<Person> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/person/{model}")
    public boolean create(@PathVariable Person model) {
        return service.Add(model);
    }

    @DeleteMapping("/person/{model}")
    public boolean destroy(@PathVariable Person model) {
        return service.Delete(model);
    }

}
