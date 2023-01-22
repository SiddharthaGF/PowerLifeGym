package com.jpgl.powerlifegym.logic.controllers;

import com.jpgl.powerlifegym.database.models.PresenceClient;
import com.jpgl.powerlifegym.logic.services.PresenceClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class CustomerAssistanceController {

    @Autowired
    PresenceClientService service;

    @GetMapping("/assistance")
    public List<PresenceClient> index() {
        return service.All();
    }

    @GetMapping("/assistance/{id}")
    public Optional<PresenceClient> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/assistance/{model}")
    public boolean create(@PathVariable PresenceClient model) {
        return service.Add(model);
    }

    @DeleteMapping("/assistance/{model}")
    public boolean destroy(@PathVariable PresenceClient model) {
        return service.Delete(model);
    }

}
