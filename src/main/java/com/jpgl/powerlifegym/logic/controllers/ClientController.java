package com.jpgl.powerlifegym.logic.controllers;

import com.jpgl.powerlifegym.database.models.person.ClientModel;
import com.jpgl.powerlifegym.logic.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public Optional<ClientModel> show(@PathVariable String idOrDni) {
        return service.Find(idOrDni);
    }

    @GetMapping("/client/exists/{idOrDni}")
    public boolean exists(@PathVariable String idOrDni) { return service.Exists(idOrDni); }

    @PostMapping ("/client")
    public ResponseEntity<?> create(@RequestBody ClientModel model) {
        return service.Add(model);
    }

    @PutMapping("/client/{client}")
    public ResponseEntity<?> update(@PathVariable ClientModel client) {
        return service.Add(client);
    }

    @DeleteMapping("/client/{client}")
    public boolean destroy(@PathVariable ClientModel client) {
        return service.Delete(client);
    }

}
