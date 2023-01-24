package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.PresenceClientsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAssistanceRepository extends CrudRepository<PresenceClientsModel, Integer> {

}
