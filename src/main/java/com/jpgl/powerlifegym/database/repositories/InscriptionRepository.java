package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.InscriptionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionRepository extends CrudRepository<InscriptionModel, Integer> {

}
