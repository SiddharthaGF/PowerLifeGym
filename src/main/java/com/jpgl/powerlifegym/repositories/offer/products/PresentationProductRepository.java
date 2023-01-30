package com.jpgl.powerlifegym.repositories.offer.products;

import com.jpgl.powerlifegym.models.offer.product.PresentationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentationProductRepository extends CrudRepository<PresentationModel, Integer> {

}
