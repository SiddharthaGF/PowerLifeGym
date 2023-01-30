package com.jpgl.powerlifegym.repositories.offer.services;

import com.jpgl.powerlifegym.models.offer.services.InscriptionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionRepository extends CrudRepository<InscriptionModel, Integer> {

}
