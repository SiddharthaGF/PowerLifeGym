package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.offer.product.ProductModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Integer> {

}
