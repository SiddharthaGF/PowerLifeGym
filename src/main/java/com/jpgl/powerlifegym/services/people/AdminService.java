package com.jpgl.powerlifegym.services.people;

import com.jpgl.powerlifegym.models.people.AdminModel;
import com.jpgl.powerlifegym.repositories.people.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    AdminRepository repository;

    public List<AdminModel> All(){
        return (List<AdminModel>) repository.findAll();
    }

    public Optional<AdminModel> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(AdminModel model) {
        return Add(model);
    }

    public boolean Add(AdminModel model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(AdminModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
