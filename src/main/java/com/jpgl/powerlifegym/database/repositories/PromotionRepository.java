package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.PromotionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends CrudRepository<PromotionModel, Integer> {

}
