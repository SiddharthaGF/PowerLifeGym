package com.jpgl.powerlifegym.database.controllers;

import com.jpgl.powerlifegym.database.models.Group;
import com.jpgl.powerlifegym.database.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class GroupController {

    @Autowired
    GroupService service;

    @GetMapping("/groups")
    public List<Group> index() {
        return service.All();
    }

    @GetMapping("/group/{id}")
    public Optional<Group> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/group/{model}")
    public boolean create(@PathVariable Group model) {
        return service.Add(model);
    }

    @DeleteMapping("/group/{model}")
    public boolean destroy(@PathVariable Group model) {
        return service.Delete(model);
    }

}
