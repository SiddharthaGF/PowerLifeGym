package com.jpgl.powerlifegym.controllers;

import com.jpgl.powerlifegym.models.User;
import com.jpgl.powerlifegym.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/users")
    public List<User> index() {
        return service.All();
    }

    @GetMapping("/user/{id}")
    public Optional<User> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/user/{model}")
    public boolean create(@PathVariable User model) {
        return service.Add(model);
    }

    @DeleteMapping("/user/{model}")
    public boolean destroy(@PathVariable User model) {
        return service.Delete(model);
    }

}
