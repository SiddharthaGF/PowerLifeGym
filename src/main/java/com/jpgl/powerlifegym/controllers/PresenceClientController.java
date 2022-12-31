package com.jpgl.powerlifegym.controllers;

import com.jpgl.powerlifegym.models.PresenceClient;
import com.jpgl.powerlifegym.services.PresenceClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class PresenceClientController {

    @Autowired
    PresenceClientService service;

    @GetMapping("/presence")
    public List<PresenceClient> index() {
        return service.All();
    }

    @GetMapping("/presence/{id}")
    public Optional<PresenceClient> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/presence/{model}")
    public boolean create(@PathVariable PresenceClient model) {
        return service.Add(model);
    }

    @DeleteMapping("/presence/{model}")
    public boolean destroy(@PathVariable PresenceClient model) {
        return service.Delete(model);
    }

}
