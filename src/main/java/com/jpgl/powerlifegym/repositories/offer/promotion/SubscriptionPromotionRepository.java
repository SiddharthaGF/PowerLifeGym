package com.jpgl.powerlifegym.repositories.offer.promotion;

import com.jpgl.powerlifegym.controllers.offer.promotion.SubscriptionPromotionController;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionPromotionRepository extends CrudRepository<SubscriptionPromotionController, Integer> {

}
