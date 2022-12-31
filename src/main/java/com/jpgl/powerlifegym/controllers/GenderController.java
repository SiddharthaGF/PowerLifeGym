package com.jpgl.powerlifegym.controllers;

import com.jpgl.powerlifegym.models.Gender;
import com.jpgl.powerlifegym.models.User;
import com.jpgl.powerlifegym.services.GenderService;
import com.jpgl.powerlifegym.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class GenderController {

    @Autowired
    GenderService service;

    @GetMapping("/genders")
    public List<Gender> index() {
        return service.All();
    }

    @GetMapping("/gender/{id}")
    public Optional<Gender> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/gender/{gender}")
    public boolean create(@PathVariable Gender gender) {
        return service.Add(gender);
    }

    @DeleteMapping("/gender/{gender}")
    public boolean destroy(@PathVariable Gender gender) {
        return service.Delete(gender);
    }

}