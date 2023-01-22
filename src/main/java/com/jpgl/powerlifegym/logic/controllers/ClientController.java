package com.jpgl.powerlifegym.logic.controllers;

import com.jpgl.powerlifegym.database.models.Client;
import com.jpgl.powerlifegym.logic.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class ClientController {

    @Autowired
    ClientService service;

    @GetMapping("/clients")
    public Object index(
            @RequestParam(required = false) String dni,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String cellphoneNumber,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Timestamp birthdate
    ) {
        return service.Find(dni, name, lastname, gender, cellphoneNumber, email, birthdate);
    }

    @GetMapping("/client/{idOrDni}")
    public Optional<Client> show(@PathVariable String idOrDni) {
        return service.Find(idOrDni);
    }

    @GetMapping("/client/exists/{idOrDni}")
    public boolean exists(@PathVariable String idOrDni) { return service.Exists(idOrDni); }

    @PutMapping("/client/{client}")
    public boolean create(@PathVariable Client client) {
        return service.Add(client);
    }

    @DeleteMapping("/client/{client}")
    public boolean destroy(@PathVariable Client client) {
        return service.Delete(client);
    }

}
