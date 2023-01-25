package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.promotion.SubscriptionPaymentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionPaymentRepository extends CrudRepository<SubscriptionPaymentModel, Integer> {

}
