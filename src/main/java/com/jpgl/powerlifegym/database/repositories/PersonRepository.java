package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
