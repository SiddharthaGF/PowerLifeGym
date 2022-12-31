package com.jpgl.powerlifegym.repositories;

import com.jpgl.powerlifegym.models.PhysicalMonitoring;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicalMonitoringRepository extends CrudRepository<PhysicalMonitoring, Integer> {

}
