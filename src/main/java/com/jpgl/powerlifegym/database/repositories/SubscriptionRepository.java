package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.offer.services.SubscriptionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends CrudRepository<SubscriptionModel, Integer> {

}
