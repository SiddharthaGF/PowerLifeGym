package com.jpgl.powerlifegym.controllers.people.employee;

import com.jpgl.powerlifegym.models.people.employee.InstructorModel;
import com.jpgl.powerlifegym.services.people.employee.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class InstructorController {

    @Autowired
    InstructorService service;

    @GetMapping("/instructors")
    public List<InstructorModel> index() {
        return service.All();
    }

    @GetMapping("/instructor/{id}")
    public Optional<InstructorModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PostMapping("/instructor")
    public ResponseEntity<?> create(@RequestBody InstructorModel model) {
        return service.Add(model);
    }

    @DeleteMapping("/instructor/{model}")
    public boolean destroy(@PathVariable InstructorModel model) {
        return service.Delete(model);
    }

}
