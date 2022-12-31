package com.jpgl.powerlifegym.repositories;

import com.jpgl.powerlifegym.models.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Integer> {

}
