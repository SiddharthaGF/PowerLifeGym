package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.PresentationProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentationProductRepository extends CrudRepository<PresentationProduct, Integer> {

}
