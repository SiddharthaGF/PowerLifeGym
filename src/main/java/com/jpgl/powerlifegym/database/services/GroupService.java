package com.jpgl.powerlifegym.database.services;

import com.jpgl.powerlifegym.database.models.Group;
import com.jpgl.powerlifegym.database.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    GroupRepository repository;

    public List<Group> All(){
        return (List<Group>) repository.findAll();
    }

    public Optional<Group> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(Group model) {
        return Add(model);
    }

    public boolean Add(Group model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(Group model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
