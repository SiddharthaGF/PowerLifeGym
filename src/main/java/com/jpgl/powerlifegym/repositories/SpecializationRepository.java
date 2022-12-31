package com.jpgl.powerlifegym.repositories;

import com.jpgl.powerlifegym.models.Specialization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepository extends CrudRepository<Specialization, Integer> {

}
