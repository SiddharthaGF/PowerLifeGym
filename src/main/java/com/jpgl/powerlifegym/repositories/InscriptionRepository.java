package com.jpgl.powerlifegym.repositories;

import com.jpgl.powerlifegym.models.Inscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionRepository extends CrudRepository<Inscription, Integer> {

}
