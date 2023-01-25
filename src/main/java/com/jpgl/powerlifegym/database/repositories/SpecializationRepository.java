package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.person.employee.SpecializationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepository extends CrudRepository<SpecializationModel, Integer> {

}
