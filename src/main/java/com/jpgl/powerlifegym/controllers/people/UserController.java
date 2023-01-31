package com.jpgl.powerlifegym.controllers.people;

import com.jpgl.powerlifegym.models.people.UserModel;
import com.jpgl.powerlifegym.services.people.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    public List<UserModel> index()
    {
        return service.All();
    }

    @GetMapping("/{id}")
    public Optional<UserModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserModel model) {
        return service.Add(model);
    }

    @DeleteMapping("/{model}")
    public boolean destroy(@PathVariable UserModel model) {
        return service.Delete(model);
    }

    @GetMapping("/exists/cellPhoneNumber/{number}")
    public ResponseEntity<?> existsCellPhoneNumber(@PathVariable String number) {
        return service.FindByCellphoneNumber(number);
    }

}
