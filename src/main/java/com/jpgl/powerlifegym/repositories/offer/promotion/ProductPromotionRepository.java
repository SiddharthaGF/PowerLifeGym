package com.jpgl.powerlifegym.repositories.offer.promotion;

import com.jpgl.powerlifegym.models.offer.promotion.ProductPromotionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPromotionRepository extends CrudRepository<ProductPromotionModel, Integer> {

}
