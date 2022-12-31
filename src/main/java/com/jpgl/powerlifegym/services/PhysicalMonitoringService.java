package com.jpgl.powerlifegym.services;

import com.jpgl.powerlifegym.models.PhysicalMonitoring;
import com.jpgl.powerlifegym.repositories.PhysicalMonitoringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhysicalMonitoringService {

    @Autowired
    PhysicalMonitoringRepository repository;

    public List<PhysicalMonitoring> All(){
        return (List<PhysicalMonitoring>) repository.findAll();
    }

    public Optional<PhysicalMonitoring> Find(int id) {
        return repository.findById(id);
    }

    public boolean Update(PhysicalMonitoring model) {
        return Add(model);
    }

    public boolean Add(PhysicalMonitoring model) {
        try {
            repository.save(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean Delete(PhysicalMonitoring model) {
        try {
            repository.delete(model);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
