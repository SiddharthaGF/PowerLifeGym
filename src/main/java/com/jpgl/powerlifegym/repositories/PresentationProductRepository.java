package com.jpgl.powerlifegym.repositories;

import com.jpgl.powerlifegym.models.PresentationProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentationProductRepository extends CrudRepository<PresentationProduct, Integer> {

}
