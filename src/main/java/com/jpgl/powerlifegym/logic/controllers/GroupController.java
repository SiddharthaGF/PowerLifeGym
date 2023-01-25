package com.jpgl.powerlifegym.logic.controllers;

import com.jpgl.powerlifegym.database.models.person.GroupModel;
import com.jpgl.powerlifegym.logic.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class GroupController {

    @Autowired
    GroupService service;

    @GetMapping("/groups")
    public List<GroupModel> index() {
        return service.All();
    }

    @GetMapping("/group/{id}")
    public Optional<GroupModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PostMapping("/group")
    public ResponseEntity<?> create(@RequestBody GroupModel model) {
        System.out.println(model.getIdInstructor());
        return service.Add(model);
    }

    @DeleteMapping("/group/{model}")
    public boolean destroy(@PathVariable GroupModel model) {
        return service.Delete(model);
    }

}
