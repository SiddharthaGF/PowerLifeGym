package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.models.UserModel;
import com.jpgl.powerlifegym.database.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<UserModel> All(){
        return (List<UserModel>) repository.findAll();
    }

    public List<UserModel> FindByNickOrEmail(String nick, String email){
        return repository.findByNickContainingOrEmailContaining(nick, email);
    }

    public Optional<UserModel> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(UserModel model) {
        return Add(model);
    }

    public boolean Add(UserModel model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(UserModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
