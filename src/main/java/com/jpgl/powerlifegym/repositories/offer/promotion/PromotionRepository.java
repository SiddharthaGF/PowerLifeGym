package com.jpgl.powerlifegym.repositories.offer.promotion;

import com.jpgl.powerlifegym.models.offer.promotion.PromotionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends CrudRepository<PromotionModel, Integer> {

}
