package com.jpgl.powerlifegym.logic.controllers;

import com.jpgl.powerlifegym.database.models.Person;
import com.jpgl.powerlifegym.logic.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class PersonController {

    @Autowired
    PersonService service;

    @GetMapping("/people")
    public List<Person> index() {
        return service.All();
    }

    @GetMapping("/person/exists/{idOrDni}")
    public boolean exists(@PathVariable String idOrDni) { return service.Exists(idOrDni); }

    @GetMapping("/person/{idOrDni}")
    public Optional<Person> show(@PathVariable String idOrDni) {
        return service.Find(idOrDni);
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
