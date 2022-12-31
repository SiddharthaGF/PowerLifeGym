package com.jpgl.powerlifegym.controllers;

import com.jpgl.powerlifegym.models.Inscription;
import com.jpgl.powerlifegym.models.User;
import com.jpgl.powerlifegym.services.InscriptionService;
import com.jpgl.powerlifegym.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class InscriptionController {

    @Autowired
    InscriptionService service;

    @GetMapping("/inscription")
    public List<Inscription> index() {
        return service.All();
    }

    @GetMapping("/inscription/{id}")
    public Optional<Inscription> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/inscription/{model}")
    public boolean create(@PathVariable Inscription model) {
        return service.Add(model);
    }

    @DeleteMapping("/inscription/{model}")
    public boolean destroy(@PathVariable Inscription model) {
        return service.Delete(model);
    }

}
