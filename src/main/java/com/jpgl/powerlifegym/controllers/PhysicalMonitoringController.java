package com.jpgl.powerlifegym.controllers;

import com.jpgl.powerlifegym.models.PhysicalMonitoring;
import com.jpgl.powerlifegym.services.PhysicalMonitoringService;
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
    public List<PhysicalMonitoring> index() {
        return service.All();
    }

    @GetMapping("/monitoring/{id}")
    public Optional<PhysicalMonitoring> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/monitoring/{model}")
    public boolean create(@PathVariable PhysicalMonitoring model) {
        return service.Add(model);
    }

    @DeleteMapping("/monitoring/{model}")
    public boolean destroy(@PathVariable PhysicalMonitoring model) {
        return service.Delete(model);
    }

}
