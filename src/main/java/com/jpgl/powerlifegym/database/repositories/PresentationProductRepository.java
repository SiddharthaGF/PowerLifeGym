package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.Presentation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentationProductRepository extends CrudRepository<Presentation, Integer> {

}
