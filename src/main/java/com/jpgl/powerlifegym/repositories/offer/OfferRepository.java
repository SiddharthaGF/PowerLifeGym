package com.jpgl.powerlifegym.repositories.offer;

import com.jpgl.powerlifegym.models.offer.OfferModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends CrudRepository<OfferModel, Integer> {

}
