package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.CellphoneNumberModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CellphoneNumberRepository extends CrudRepository<CellphoneNumberModel, Integer> {

    boolean existsByIdOrNumber(int id, String Number);

    Optional<CellphoneNumberModel> findByIdOrNumber(int id, String idOrNumber);
}
