package com.jpgl.powerlifegym.repositories;

import com.jpgl.powerlifegym.models.Supplement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplementRepository extends CrudRepository<Supplement, Integer> {

}
