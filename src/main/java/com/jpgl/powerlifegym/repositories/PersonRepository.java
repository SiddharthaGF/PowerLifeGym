package com.jpgl.powerlifegym.repositories;

import com.jpgl.powerlifegym.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
