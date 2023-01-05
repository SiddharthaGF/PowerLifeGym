package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.PhysicalMonitoring;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicalMonitoringRepository extends CrudRepository<PhysicalMonitoring, Integer> {

}
