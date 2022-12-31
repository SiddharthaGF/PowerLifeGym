package com.jpgl.powerlifegym.repositories;

import com.jpgl.powerlifegym.models.Promotion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends CrudRepository<Promotion, Integer> {

}
