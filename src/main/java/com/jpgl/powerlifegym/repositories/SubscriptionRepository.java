package com.jpgl.powerlifegym.repositories;

import com.jpgl.powerlifegym.models.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {

}
