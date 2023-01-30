package com.jpgl.powerlifegym.controllers.people;

import com.jpgl.powerlifegym.models.people.AdminModel;
import com.jpgl.powerlifegym.services.people.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class AdminController {

    @Autowired
    AdminService service;

    @GetMapping("/admins")
    public List<AdminModel> index()
    {
        return service.All();
    }

    @GetMapping("/admin/{id}")
    public Optional<AdminModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PostMapping("/admin")
    public boolean create(@RequestBody AdminModel model) {
        return service.Add(model);
    }

    @DeleteMapping("/admin/{model}")
    public boolean destroy(@PathVariable AdminModel model) {
        return service.Delete(model);
    }

}
