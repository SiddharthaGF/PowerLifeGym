package com.jpgl.powerlifegym.repositories;

import com.jpgl.powerlifegym.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
