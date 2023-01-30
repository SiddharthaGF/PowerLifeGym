package com.jpgl.powerlifegym.repositories.invoice;

import com.jpgl.powerlifegym.models.invoice.SubscriptionPaymentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionPaymentRepository extends CrudRepository<SubscriptionPaymentModel, Integer> {

}
