package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.offer.product.ClothModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothRepository extends CrudRepository<ClothModel, Integer> {

}
