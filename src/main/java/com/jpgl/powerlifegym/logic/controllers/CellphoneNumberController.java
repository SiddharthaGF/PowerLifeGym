package com.jpgl.powerlifegym.logic.controllers;

import com.jpgl.powerlifegym.database.models.CellphoneNumberModel;
import com.jpgl.powerlifegym.logic.services.CellphoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class CellphoneNumberController {

    @Autowired
    CellphoneNumberService service;

    @GetMapping("/cellphoneNumbers")
    public List<CellphoneNumberModel> index() {
        return service.All();
    }

    @GetMapping("/cellphoneNumber/{idOrNumber}")
    public Optional<CellphoneNumberModel> findByIdOrNumber(@PathVariable String idOrNumber) {
        return service.findByIdOrNumber(idOrNumber);
    }

    @GetMapping("/cellphoneNumber/exists/{idOrNumber}")
    public boolean existsByIdOrNumber(@PathVariable String idOrNumber) {
        return service.existsByIdOrNumber(idOrNumber);
    }

    @PostMapping("/cellphoneNumber")
    public ResponseEntity<?> create(@RequestBody CellphoneNumberModel cellphoneNumber) {
        return service.Add(cellphoneNumber);
    }

    @DeleteMapping("/cellphoneNumber/{cellphoneNumber}")
    public boolean destroy(@PathVariable CellphoneNumberModel cellphoneNumber) {
        return service.Delete(cellphoneNumber);
    }

}
