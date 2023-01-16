package com.jpgl.powerlifegym.database.controllers;

import com.jpgl.powerlifegym.database.models.Presentation;
import com.jpgl.powerlifegym.database.services.PresentationProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class PresentationProductController {

    @Autowired
    PresentationProductService service;

    @GetMapping("/presentations")
    public List<Presentation> index() {
        return service.All();
    }

    @GetMapping("/presentation/{id}")
    public Optional<Presentation> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/presentation/{model}")
    public boolean create(@PathVariable Presentation model) {
        return service.Add(model);
    }

    @DeleteMapping("/presentation/{model}")
    public boolean destroy(@PathVariable Presentation model) {
        return service.Delete(model);
    }

}
