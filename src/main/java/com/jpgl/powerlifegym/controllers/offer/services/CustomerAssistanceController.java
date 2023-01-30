package com.jpgl.powerlifegym.controllers.offer.services;

import com.jpgl.powerlifegym.models.offer.services.PresenceClientsModel;
import com.jpgl.powerlifegym.services.offer.services.PresenceClientService;
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
    public List<PresenceClientsModel> index() {
        return service.All();
    }

    @GetMapping("/assistance/{id}")
    public Optional<PresenceClientsModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/assistance/{model}")
    public boolean create(@PathVariable PresenceClientsModel model) {
        return service.Add(model);
    }

    @DeleteMapping("/assistance/{model}")
    public boolean destroy(@PathVariable PresenceClientsModel model) {
        return service.Delete(model);
    }

}
