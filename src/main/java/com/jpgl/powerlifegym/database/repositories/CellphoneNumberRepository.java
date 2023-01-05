package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.CellphoneNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CellphoneNumberRepository extends CrudRepository<CellphoneNumber, Integer> {

}
