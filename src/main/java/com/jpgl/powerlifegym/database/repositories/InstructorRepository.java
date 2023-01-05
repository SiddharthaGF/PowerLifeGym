package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Integer> {

}
