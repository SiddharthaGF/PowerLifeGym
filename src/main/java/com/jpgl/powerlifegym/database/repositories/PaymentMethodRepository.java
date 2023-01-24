package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.PaymentMethodModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends CrudRepository<PaymentMethodModel, Integer> {

}
