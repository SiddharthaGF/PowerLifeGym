package com.jpgl.powerlifegym.logic.services;

import com.jpgl.powerlifegym.database.models.offer.services.PhysicalMonitoringModel;
import com.jpgl.powerlifegym.database.repositories.PhysicalMonitoringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhysicalMonitoringService {

    @Autowired
    PhysicalMonitoringRepository repository;

    public List<PhysicalMonitoringModel> All(){
        return (List<PhysicalMonitoringModel>) repository.findAll();
    }

    public Optional<PhysicalMonitoringModel> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(PhysicalMonitoringModel model) {
        return Add(model);
    }

    public boolean Add(PhysicalMonitoringModel model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(PhysicalMonitoringModel model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
