package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.Gender;
import org.springframework.data.repository.CrudRepository;

public interface GenderRepository extends CrudRepository<Gender, Integer> {

}
