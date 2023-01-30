package com.jpgl.powerlifegym.repositories.offer.services;

import com.jpgl.powerlifegym.models.offer.services.PhysicalMonitoringModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicalMonitoringRepository extends CrudRepository<PhysicalMonitoringModel, Integer> {

}
