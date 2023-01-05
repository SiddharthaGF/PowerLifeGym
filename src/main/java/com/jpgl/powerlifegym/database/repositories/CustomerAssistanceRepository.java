package com.jpgl.powerlifegym.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAssistanceRepository extends CrudRepository<com.jpgl.powerlifegym.database.models.CustomerAssistance, Integer> {

}
