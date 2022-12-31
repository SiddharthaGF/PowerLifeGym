package com.jpgl.powerlifegym.controllers;

import com.jpgl.powerlifegym.models.Client;
import com.jpgl.powerlifegym.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class ClientController {

    @Autowired
    ClientService service;

    @GetMapping("/clients")
    public List<Client> index() {
        return service.All();
    }

    @GetMapping("/client/{id}")
    public Optional<Client> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/client/{client}")
    public boolean create(@PathVariable Client client) {
        return service.Add(client);
    }


}
