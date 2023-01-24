package com.jpgl.powerlifegym.logic.controllers;

import com.jpgl.powerlifegym.database.models.EmailModel;
import com.jpgl.powerlifegym.logic.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class EmailController {

    @Autowired
    EmailService service;

    @GetMapping("/email")
    public List<EmailModel> index() {
        return service.All();
    }

    @GetMapping("/email/{id}")
    public Optional<EmailModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PostMapping("/email")
    public ResponseEntity<?> create(@RequestBody EmailModel model) {
        return service.Add(model);
    }


    @DeleteMapping("/email/{model}")
    public boolean destroy(@PathVariable EmailModel model) {
        return service.Delete(model);
    }

}
