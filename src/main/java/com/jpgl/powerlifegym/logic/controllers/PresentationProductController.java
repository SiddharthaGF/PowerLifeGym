package com.jpgl.powerlifegym.logic.controllers;

import com.jpgl.powerlifegym.database.models.PresentationModel;
import com.jpgl.powerlifegym.logic.services.PresentationProductService;
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
    public List<PresentationModel> index() {
        return service.All();
    }

    @GetMapping("/presentation/{id}")
    public Optional<PresentationModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/presentation/{model}")
    public boolean create(@PathVariable PresentationModel model) {
        return service.Add(model);
    }

    @DeleteMapping("/presentation/{model}")
    public boolean destroy(@PathVariable PresentationModel model) {
        return service.Delete(model);
    }

}
