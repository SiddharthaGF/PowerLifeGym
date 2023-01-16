package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.PresenceClient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAssistanceRepository extends CrudRepository<PresenceClient, Integer> {

}
