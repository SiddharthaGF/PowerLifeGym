package com.jpgl.powerlifegym.logic.controllers;

import com.jpgl.powerlifegym.database.models.ClientModel;
import com.jpgl.powerlifegym.database.models.GenderModel;
import com.jpgl.powerlifegym.logic.services.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class GenderController {

    @Autowired
    GenderService service;

    @GetMapping("/genders")
    public List<GenderModel> index() {
        return service.All();
    }

    @GetMapping("/gender/{id}")
    public Optional<GenderModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PostMapping("/gender")
    public ResponseEntity<?> create(@Valid @RequestBody GenderModel gender) {
        return service.Add(gender);
    }

    @PutMapping("/gender/{gender}")
    public ResponseEntity<?> update(@PathVariable GenderModel gender) {
        return service.Add(gender);
    }

    @DeleteMapping("/gender/{gender}")
    public boolean destroy(@PathVariable GenderModel gender) {
        return service.Delete(gender);
    }

    @GetMapping("/gender/exists/{idOrName}")
    public boolean existsByIdOrName(@PathVariable String idOrName) {
        return service.existsByIdOrName(idOrName);
    }

}