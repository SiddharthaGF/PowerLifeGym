package com.jpgl.powerlifegym.repositories;

import com.jpgl.powerlifegym.models.PresenceClient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresenceClientRepository extends CrudRepository<PresenceClient, Integer> {

}
