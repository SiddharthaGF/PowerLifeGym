package com.jpgl.powerlifegym.services.people;

import com.jpgl.powerlifegym.models.people.UserModel;
import com.jpgl.powerlifegym.repositories.people.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public Optional<UserModel> Find(int id) {
        return repository.findById(id);
    }

    public ResponseEntity<?> Update(UserModel model) {
        return Add(model);
    }

    public ResponseEntity<?> Add(UserModel model) {
        try {
            return new ResponseEntity<>(repository.save(model), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
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

    public ResponseEntity<?> FindByCellphoneNumber(String cellPhoneNumber) {
        return new ResponseEntity<>(repository.existsByCellPhoneNumber(cellPhoneNumber), HttpStatus.OK);
    }

}
