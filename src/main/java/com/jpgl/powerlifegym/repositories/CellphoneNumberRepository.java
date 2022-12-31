package com.jpgl.powerlifegym.repositories;

import com.jpgl.powerlifegym.models.CellphoneNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CellphoneNumberRepository extends CrudRepository<CellphoneNumber, Integer> {

}
