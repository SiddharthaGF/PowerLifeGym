package com.jpgl.powerlifegym.repositories;

import com.jpgl.powerlifegym.models.Gender;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GenderRepository extends CrudRepository<Gender, Integer> {

}
