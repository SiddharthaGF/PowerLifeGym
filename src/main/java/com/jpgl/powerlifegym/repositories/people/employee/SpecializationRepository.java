package com.jpgl.powerlifegym.repositories.people.employee;

import com.jpgl.powerlifegym.models.people.employee.SpecializationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepository extends CrudRepository<SpecializationModel, Integer> {

}
