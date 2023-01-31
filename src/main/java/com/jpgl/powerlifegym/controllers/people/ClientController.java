package com.jpgl.powerlifegym.controllers.people;

import com.jpgl.powerlifegym.models.people.ClientModel;
import com.jpgl.powerlifegym.services.people.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {

    @Autowired
    ClientService service;

    @GetMapping
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

    @GetMapping("/{idOrDni}")
    public Optional<ClientModel> show(@PathVariable String idOrDni) {
        return service.Find(idOrDni);
    }

    @GetMapping("/exists/{idOrDni}")
    public boolean exists(@PathVariable String idOrDni) { return service.Exists(idOrDni); }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ClientModel model) {
        return service.Add(model);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ClientModel model, @PathVariable int id) {
        return service.Update(model, id);
    }

    @DeleteMapping("/{id}")
    public boolean destroy(@PathVariable int id) {
        return service.Delete(id);
    }

}
