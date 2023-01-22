package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.SubscriptionPayment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionPaymentRepository extends CrudRepository<SubscriptionPayment, Integer> {

}
