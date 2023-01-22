package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.PaymentMethod;
import com.jpgl.powerlifegym.database.models.Supplement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Integer> {

}
