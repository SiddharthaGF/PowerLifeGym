package com.jpgl.powerlifegym.repositories.offer.promotion;

import com.jpgl.powerlifegym.models.offer.promotion.SubscriptionPromotionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionPromotionRepository extends CrudRepository<SubscriptionPromotionModel, Integer> {

}
