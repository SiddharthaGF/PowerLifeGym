package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {

}
