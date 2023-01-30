package com.jpgl.powerlifegym.repositories.offer.products;

import com.jpgl.powerlifegym.models.offer.product.SupplementModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplementRepository extends CrudRepository<SupplementModel, Integer> {

}
