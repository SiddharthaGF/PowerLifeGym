package com.jpgl.powerlifegym.repositories.offer.products;

import com.jpgl.powerlifegym.models.offer.product.ProductModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Integer> {

}
