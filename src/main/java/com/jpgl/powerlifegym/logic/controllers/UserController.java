package com.jpgl.powerlifegym.logic.controllers;

import com.jpgl.powerlifegym.database.models.UserModel;
import com.jpgl.powerlifegym.logic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/users")
    public List<UserModel> index(
            @RequestParam(required = false) String nick,
            @RequestParam(required = false) String email)
    {
        if (nick!= null || email!= null) {
            return service.FindByNickOrEmail(nick, email);
        }
        return service.All();
    }

    @GetMapping("/user/{id}")
    public Optional<UserModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PostMapping("/user")
    public boolean create(@RequestBody UserModel model) {
        return service.Add(model);
    }

    @DeleteMapping("/user/{model}")
    public boolean destroy(@PathVariable UserModel model) {
        return service.Delete(model);
    }

}
