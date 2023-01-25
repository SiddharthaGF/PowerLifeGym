package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.models.person.GroupModel;
import com.jpgl.powerlifegym.database.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    GroupRepository repository;

    public List<GroupModel> All(){
        return (List<GroupModel>) repository.findAll();
    }

    public Optional<GroupModel> Find(int id) {
        return repository.findById(id);
    }

    public ResponseEntity<?> Update(GroupModel model) {
        return Add(model);
    }

    public ResponseEntity<?> Add(GroupModel model) {
        try {
            return new ResponseEntity<>(repository.save(model), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public boolean Delete(GroupModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
