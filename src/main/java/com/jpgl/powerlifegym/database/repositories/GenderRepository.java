package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.GenderModel;
import org.springframework.data.repository.CrudRepository;

public interface GenderRepository extends CrudRepository<GenderModel, Integer> {

    boolean existsByIdOrName(int id, String idOrName);
}
