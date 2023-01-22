package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    Optional<Person> findByIdOrDni(int id, String dni);

    boolean existsByIdOrDni(int id, String dni);

}
