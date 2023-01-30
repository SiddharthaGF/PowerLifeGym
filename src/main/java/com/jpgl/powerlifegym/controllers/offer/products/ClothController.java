package com.jpgl.powerlifegym.controllers.offer.products;

import com.jpgl.powerlifegym.models.offer.product.ClothModel;
import com.jpgl.powerlifegym.services.offer.products.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class ClothController {

    @Autowired
    ClothService service;

    @GetMapping("/clothes")
    public List<ClothModel> index() {
        return service.All();
    }

    @GetMapping("/cloth/{id}")
    public Optional<ClothModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/cloth/{model}")
    public boolean update(@PathVariable ClothModel model) {
        return service.Add(model);
    }

    @PostMapping("/cloth")
    public boolean create(@RequestBody ClothModel model) {
        return service.Add(model);
    }

    @DeleteMapping("/cloth/{model}")
    public boolean destroy(@PathVariable ClothModel model) {
        return service.Delete(model);
    }

}
