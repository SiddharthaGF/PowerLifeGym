package com.jpgl.powerlifegym.repositories;

import com.jpgl.powerlifegym.models.Cloth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothRepository extends CrudRepository<Cloth, Integer> {

}
