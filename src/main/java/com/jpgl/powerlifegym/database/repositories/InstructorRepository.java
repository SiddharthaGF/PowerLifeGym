package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.person.employee.InstructorModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends CrudRepository<InstructorModel, Integer> {

}
