package com.jpgl.powerlifegym.controllers.offer.services;

import com.jpgl.powerlifegym.models.offer.services.PhysicalMonitoringModel;
import com.jpgl.powerlifegym.services.offer.services.PhysicalMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class PhysicalMonitoringController {

    @Autowired
    PhysicalMonitoringService service;

    @GetMapping("/monitoring")
    public List<PhysicalMonitoringModel> index() {
        return service.All();
    }

    @GetMapping("/monitoring/{id}")
    public Optional<PhysicalMonitoringModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/monitoring/{model}")
    public boolean create(@PathVariable PhysicalMonitoringModel model) {
        return service.Add(model);
    }

    @DeleteMapping("/monitoring/{model}")
    public boolean destroy(@PathVariable PhysicalMonitoringModel model) {
        return service.Delete(model);
    }

}
