package com.jpgl.powerlifegym.database.controllers;

import com.jpgl.powerlifegym.database.models.Email;
import com.jpgl.powerlifegym.database.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class EmailController {

    @Autowired
    EmailService service;

    @GetMapping("/email")
    public List<Email> index() {
        return service.All();
    }

    @GetMapping("/email/{id}")
    public Optional<Email> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/email/{model}")
    public boolean create(@PathVariable Email model) {
        return service.Add(model);
    }

    @DeleteMapping("/email/{model}")
    public boolean destroy(@PathVariable Email model) {
        return service.Delete(model);
    }

}
