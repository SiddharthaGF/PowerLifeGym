package com.jpgl.powerlifegym.repositories.offer.products;

import com.jpgl.powerlifegym.models.offer.product.ClothModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothRepository extends CrudRepository<ClothModel, Integer> {

}
