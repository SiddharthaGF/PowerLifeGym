package com.jpgl.powerlifegym.repositories.offer.services;

import com.jpgl.powerlifegym.models.offer.services.SubscriptionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends CrudRepository<SubscriptionModel, Integer> {

}
