package com.jpgl.powerlifegym.database.controllers;

import com.jpgl.powerlifegym.database.models.CustomerAssistance;
import com.jpgl.powerlifegym.database.services.PresenceClientService;
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
    public List<CustomerAssistance> index() {
        return service.All();
    }

    @GetMapping("/assistance/{id}")
    public Optional<CustomerAssistance> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/assistance/{model}")
    public boolean create(@PathVariable CustomerAssistance model) {
        return service.Add(model);
    }

    @DeleteMapping("/assistance/{model}")
    public boolean destroy(@PathVariable CustomerAssistance model) {
        return service.Delete(model);
    }

}
