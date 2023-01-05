package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.Supplement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplementRepository extends CrudRepository<Supplement, Integer> {

}
