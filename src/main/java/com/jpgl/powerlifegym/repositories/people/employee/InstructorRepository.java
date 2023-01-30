package com.jpgl.powerlifegym.repositories.people.employee;

import com.jpgl.powerlifegym.models.people.employee.InstructorModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends CrudRepository<InstructorModel, Integer> {

}
