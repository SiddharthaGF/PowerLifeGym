package com.jpgl.powerlifegym.controllers;

import com.jpgl.powerlifegym.models.CellphoneNumber;
import com.jpgl.powerlifegym.models.Client;
import com.jpgl.powerlifegym.services.CellphoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class CellphoneNumberController {

    @Autowired
    CellphoneNumberService service;

    @GetMapping("/cellphoneNumbers")
    public List<CellphoneNumber> index() {
        return service.All();
    }

    @GetMapping("/cellphoneNumber/{id}")
    public Optional<CellphoneNumber> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/cellphoneNumber/{cellphoneNumber}")
    public boolean create(@PathVariable CellphoneNumber cellphoneNumber) {
        return service.Add(cellphoneNumber);
    }

    @DeleteMapping("/cellphoneNumber/{cellphoneNumber}")
    public boolean destroy(@PathVariable CellphoneNumber cellphoneNumber) {
        return service.Delete(cellphoneNumber);
    }

}
