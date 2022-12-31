package com.jpgl.powerlifegym.services;

import com.jpgl.powerlifegym.models.User;
import com.jpgl.powerlifegym.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> All(){
        return (List<User>) repository.findAll();
    }

    public Optional<User> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(User user) {
        return Add(user);
    }

    public boolean Add(User user) {
        try {
            repository.save(user);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(User user) {
        try {
            repository.delete(user);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
