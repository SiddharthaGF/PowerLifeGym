package com.jpgl.powerlifegym.controllers.offer.services;

import com.jpgl.powerlifegym.models.offer.services.InscriptionModel;
import com.jpgl.powerlifegym.services.offer.services.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class InscriptionController {

    @Autowired
    InscriptionService service;

    @GetMapping("/inscriptions")
    public List<InscriptionModel> index() {
        return service.All();
    }

    @GetMapping("/inscription/{id}")
    public Optional<InscriptionModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/inscription/{model}")
    public boolean create(@PathVariable InscriptionModel model) {
        return service.Add(model);
    }

    @DeleteMapping("/inscription/{model}")
    public boolean destroy(@PathVariable InscriptionModel model) {
        return service.Delete(model);
    }

}
