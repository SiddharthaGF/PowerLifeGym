package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.Cloth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothRepository extends CrudRepository<Cloth, Integer> {

}
